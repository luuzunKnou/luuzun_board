package com.luuzun.article.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.article.model.ArticleContent;
import com.luuzun.article.model.ArticleContentDao;
import com.luuzun.controller.CommandHandler;
import com.luuzun.util.MySqlSessionFactory;

public class ReadArticleHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ArticleContent articleContent = new ArticleContent();
		int articleId = Integer.parseInt(req.getParameter("articleNo"));

		try (SqlSession session = MySqlSessionFactory.openSession();){
			ArticleContentDao dao = session.getMapper(ArticleContentDao.class);
			articleContent = dao.selectById(articleId);
			req.setAttribute("articleContent", articleContent);
		}
		return "/WEB-INF/view/article/showArticleContent.jsp";
	}
}
