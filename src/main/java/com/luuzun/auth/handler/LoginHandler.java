package com.luuzun.auth.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.controller.CommandHandler;
import com.luuzun.member.model.Member;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;

public class LoginHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/member/loginForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String id = req.getParameter("id");
			String pass = req.getParameter("password");

			Connection con = null;
			SqlSession session= null;

			try{
				session = MySqlSessionFactory.openSession();
				MemberDao dao = session.getMapper(MemberDao.class);
				
				Member member = dao.selectById(id);
				if(member == null){
					//id가 없을 경우, 회원가입을 유도해야한다.
					req.setAttribute("notJoin", true);
					return "/WEB-INF/view/member/loginForm.jsp";
				}
				//비밀번호 일치 여부
				if(member.getMemberPassword().equals(pass)==false){
					req.setAttribute("notMatchPassword", true);
					return "/WEB-INF/view/member/loginForm.jsp";
				}
				req.setAttribute("userAuth", id);
				req.getSession().setAttribute("userAuth", id);
				res.sendRedirect(req.getContextPath()+"/index.jsp");
				return null;
			}finally{
				session.close();
			}
		}
		return null;
	}
}