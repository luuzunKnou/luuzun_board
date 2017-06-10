package com.luuzun.article.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.article.model.Article;
import com.luuzun.article.model.ArticleDao;
import com.luuzun.controller.CommandHandler;
import com.luuzun.util.MySqlSessionFactory;

public class ShowArticleListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Article> articleList;

		try (SqlSession session = MySqlSessionFactory.openSession();){
			ArticleDao dao = session.getMapper(ArticleDao.class);
			articleList = dao.selectByAll();
			
			System.out.println(articleList.get(0));
			req.setAttribute("articleList", articleList);
		}
		return "/WEB-INF/view/article/showArticleList.jsp";
	}
}
