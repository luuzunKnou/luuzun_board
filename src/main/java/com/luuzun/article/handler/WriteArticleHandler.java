package com.luuzun.article.handler;

import java.io.File;
import java.util.Date;
import java.util.Enumeration;

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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteArticleHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String memberId = (String) req.getSession().getAttribute("userAuth");
		if(req.getMethod().equalsIgnoreCase("get")){
			req.setAttribute("writeId", memberId);
			return "/WEB-INF/view/article/writeArticleForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			/// 파일 upload를 위한 세팅
			String uploadPath = req.getSession().getServletContext().getRealPath("upload");
			File dir = new File(uploadPath);
			if(dir.exists() == false)
				dir.mkdirs();
			int size = 1024*1024*10;
			String key="";
			String fileName="";
			System.out.println(uploadPath);
			///
			
			try(SqlSession session = MySqlSessionFactory.openSession();){

				//파일 저장
				MultipartRequest multi = new MultipartRequest(
						req, uploadPath, size, "UTF-8",
						new DefaultFileRenamePolicy());
				Enumeration<?> files = multi.getFileNames();
				
				key = (String)files.nextElement();
				fileName = multi.getFilesystemName(key);
				System.out.println(key + " = " + fileName);
				req.setAttribute("fileName", fileName);
				//
				
				String title = multi.getParameter("title");
				String content = multi.getParameter("content");
				MemberDao memberDao = session.getMapper(MemberDao.class);
				ArticleDao articleDao = session.getMapper(ArticleDao.class);
				ArticleContentDao articleContentDao = session.getMapper(ArticleContentDao.class);
				
				Member member = memberDao.selectById(memberId);
				Article article = new Article(member, title, new Date(), new Date());
				System.out.println(article);
				articleDao.insert(article);
				article.setArticleNo(articleDao.selectLastId());
				ArticleContent articleContent = new ArticleContent(article, content, fileName);
				articleContentDao.insert(articleContent);
				
				
				session.commit();
			}

			return "/WEB-INF/view/article/writeArticleSuccess.jsp";
		}
		return null;
	}
}
