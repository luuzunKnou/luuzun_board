package com.luuzun.article.handler;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.article.model.Article;
import com.luuzun.article.model.ArticleContent;
import com.luuzun.article.model.ArticleContentDao;
import com.luuzun.article.model.ArticleDao;
import com.luuzun.controller.CommandHandler;
import com.luuzun.jdbc.JdbcUtil;
import com.luuzun.member.model.Member;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;

public class WriteArticleHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/newArticleForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String memberId = (String) req.getSession().getAttribute("userAuth");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			Connection con = null;
			
			try{
				SqlSession session= null;
				session = MySqlSessionFactory.openSession();
				MemberDao dao = session.getMapper(MemberDao.class);
				
				Member member = dao.selectById(memberId);
				System.out.println(member);
				Date now = new Date();
				int articleNo = ArticleDao.getInstance().insert(con, 
						new Article(0, member.getMemberId(), member.getMemberName(), title, now, now, 0));
				
				ArticleContentDao.getInstance().insert(con, new ArticleContent(articleNo, content));
				session.commit();
				return "/WEB-INF/view/newArticleSuccess.jsp";

			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
			} finally {
				JdbcUtil.close(con);
			}
		}
		return null;
	}
}
