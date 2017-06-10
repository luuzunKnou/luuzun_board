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
				
				postProcess(req, res);
				
				session.commit();
			}

			return "/WEB-INF/view/article/writeArticleSuccess.jsp";
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private String postProcess(HttpServletRequest req, HttpServletResponse res){
		//upload 폴더 만들기
		@SuppressWarnings("deprecation")
		String uploadPath = req.getRealPath("upload");
		File dir = new File(uploadPath);
		if(dir.exists() == false)
			dir.mkdirs();
		System.out.println(uploadPath);

		int size = 1024*1024*10;
		
		try {
			MultipartRequest multi = new MultipartRequest(
					req,
					uploadPath,
					size,
					"UTF-8",
					new DefaultFileRenamePolicy());
			Enumeration<?> files = multi.getFileNames();
			String key="";
			String filename="";
			
			key = (String)files.nextElement();
			filename = multi.getFilesystemName(key);
			System.out.println(key + " = " + filename);
			
			req.setAttribute("file", filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "fileUploadProcess.jsp";
	}
}
