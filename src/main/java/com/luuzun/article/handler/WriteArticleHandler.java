package com.luuzun.article.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.article.model.Article;
import com.luuzun.article.model.ArticleContent;
import com.luuzun.article.model.ArticleContentDao;
import com.luuzun.article.model.ArticleDao;
import com.luuzun.controller.CommandHandler;
import com.luuzun.member.model.Member;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;

public class WriteArticleHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String memberId = (String) req.getSession().getAttribute("userAuth");
		if(req.getMethod().equalsIgnoreCase("get")){
			req.setAttribute("writeId", memberId);
			return "/WEB-INF/view/article/writeArticleForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			try(SqlSession session = MySqlSessionFactory.openSession();){
				
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				
				MemberDao memberDao = session.getMapper(MemberDao.class);
				ArticleDao articleDao = session.getMapper(ArticleDao.class);
				ArticleContentDao articleContentDao = session.getMapper(ArticleContentDao.class);

				Member member = memberDao.selectById(memberId);
				Article article = new Article(member, title, new Date(), new Date());
				articleDao.insert(article);
				article.setArticleNo(articleDao.selectLastId());
	
				ArticleContent articleContent = new ArticleContent(article, content, "");
				articleContentDao.insert(articleContent);
				
				session.commit();
			}

			return "/WEB-INF/view/article/writeArticleSuccess.jsp";
		}
		return null;
	}
}
