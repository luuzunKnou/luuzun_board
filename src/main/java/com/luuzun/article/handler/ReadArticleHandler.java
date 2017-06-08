package com.luuzun.article.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luuzun.article.model.Article;
import com.luuzun.article.model.ArticleContent;
import com.luuzun.article.model.ArticleContentDao;
import com.luuzun.article.model.ArticleDao;
import com.luuzun.controller.CommandHandler;
import com.luuzun.jdbc.ConnectionProvider;
import com.luuzun.jdbc.JdbcUtil;

public class ReadArticleHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			Article article = new Article();
			ArticleContent articleContent = new ArticleContent();
			
			Connection conn = null;
			int articleId = Integer.parseInt(req.getParameter("articleNo"));
			
			try {
				conn = ConnectionProvider.getConnection();
				ArticleDao.getInstance().updateCount(conn, articleId);
				article = ArticleDao.getInstance().selectArticleById(conn, articleId);
				articleContent = ArticleContentDao.getInstance().selectArticleContentById(conn, articleId);
				
				req.setAttribute("article", article);
				req.setAttribute("articleContent", articleContent);
				return "/WEB-INF/view/showContent.jsp";
			} finally {
				JdbcUtil.close(conn);
			}

		}else if(req.getMethod().equalsIgnoreCase("post")){

		}
		return null;
	}
}
