package com.luuzun.article.handler;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.article.model.ArticleContent;
import com.luuzun.article.model.ArticleContentDao;
import com.luuzun.article.model.ArticleDao;
import com.luuzun.controller.CommandHandler;
import com.luuzun.util.MySqlSessionFactory;

public class ReadArticleHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ArticleContent articleContent = new ArticleContent();
		
		String isFromList = req.getParameter("isFromList");
		System.out.println("@@@"+isFromList);
		int articleNo = Integer.parseInt(req.getParameter("articleNo"));
		String ReaderId = (String) req.getSession().getAttribute("userAuth");

		try (SqlSession session = MySqlSessionFactory.openSession();){
			ArticleContentDao dao = session.getMapper(ArticleContentDao.class);
			articleContent = dao.selectById(articleNo);
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			/*if(isFromList != null){
				articleDao.addCnt(articleNo);
			}*/
			String CookieName = "artiCleNo" + articleContent.getArticle().getArticleNo() +
					"artiCleId" + ReaderId;
			
			Cookie cookie = new Cookie(URLEncoder.encode(CookieName,"UTF-8") , "true");
			
			cookie.setMaxAge(60*60*24);
			res.addCookie(cookie);
			
			boolean isCounted = false;
			Cookie[] cookies = req.getCookies();
			if(cookies!=null){
				for(int i =0; i<cookies.length; i++){
					System.out.println("iscount == true : " + cookies[i].getName());
					if(cookies[i].getName().equals(CookieName)){
						isCounted = true;
					}
				}
			}
			System.out.println(isCounted);
			if(!isCounted){
				articleDao.addCnt(articleNo);
			}
			
			for (Cookie cookieTest : cookies) {
				System.out.println("@@"+cookieTest.getName() + "::" + cookieTest.getValue());
			}
			
			req.setAttribute("articleContent", articleContent);
			req.setAttribute("articleNo", articleNo);
			session.commit();
		}
		return "/WEB-INF/view/article/showArticleContent.jsp";
	}
}