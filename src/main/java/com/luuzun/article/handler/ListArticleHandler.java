package com.luuzun.article.handler;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luuzun.article.model.Article;
import com.luuzun.article.model.ArticleDao;
import com.luuzun.controller.CommandHandler;
import com.luuzun.jdbc.ConnectionProvider;
import com.luuzun.jdbc.JdbcUtil;

public class ListArticleHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			List<Article> articleList = new ArrayList<>();
			Connection conn = null;

			try {
				conn = ConnectionProvider.getConnection();
				articleList = ArticleDao.getInstance().selectList(conn);
				req.setAttribute("articleList", articleList);
				return "/WEB-INF/view/showArticleList.jsp";
			} finally {
				JdbcUtil.close(conn);
			}

		}else if(req.getMethod().equalsIgnoreCase("post")){

		}
		return null;
	}
}
