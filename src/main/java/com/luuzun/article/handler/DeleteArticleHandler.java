package com.luuzun.article.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.article.model.ArticleDao;
import com.luuzun.controller.CommandHandler;
import com.luuzun.util.MySqlSessionFactory;

public class DeleteArticleHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int articleNo= Integer.parseInt(req.getParameter("articleNo"));
		String memberId = (String) req.getSession().getAttribute("userAuth");

		if(!memberId.equals(req.getParameter("memberId"))){
			System.out.println(memberId +" : "+req.getParameter("memberId"));
			req.setAttribute("isPermission", false);
			return "readArticle.do";
		}
		
		try (SqlSession session = MySqlSessionFactory.openSession();){
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			articleDao.delete(articleNo);
			session.commit();
		}
		return "/WEB-INF/view/article/deleteSuccess.jsp";
	}
}
