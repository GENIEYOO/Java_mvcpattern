package article.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import article.models.ArticleDAO;
import article.models.ArticleDAOImpl;
import article.models.ArticleVO;

public class ArticleDetail extends AbstractController {
	private static Logger logger = Logger.getLogger(ArticleDetail.class);
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		ArticleDAO articleDAO = ArticleDAOImpl.getInstance();
		try {
			long no = Long.parseLong(request.getParameter("no"));
			articleDAO.updateViewcount(no);
//			ArticleVO articleVO = articleDAO.getDetail(no);
			return new ModelAndView("/WEB-INF/views/article/detail.jsp","articleVO",articleDAO.getDetail(no));
			
			
//			ArticleVO x = new ArticleVO();
//			x.setName("name1");
//			
			
			
		} catch (Exception e) {
			logger.info(e.toString());
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
			return mav;
		}
	}
}
