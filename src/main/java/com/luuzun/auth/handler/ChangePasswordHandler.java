package com.luuzun.auth.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.controller.CommandHandler;
import com.luuzun.jdbc.ConnectionProvider;
import com.luuzun.jdbc.JdbcUtil;
import com.luuzun.member.model.Member;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;

public class ChangePasswordHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/member/changePasswordForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String memberId = (String) req.getSession().getAttribute("userAuth");
			String oldPassword = req.getParameter("oldPassword");
			String newPassword = req.getParameter("newPassword");
			
			try(SqlSession session = MySqlSessionFactory.openSession();){
				MemberDao dao = session.getMapper(MemberDao.class);
				Member member = dao.selectById(memberId);
				
				if(member.getMemberPassword().equals(oldPassword)==false){
					req.setAttribute("notMatchPassword", true);
					return "/WEB-INF/view/member/changePasswordForm.jsp";
				}
				
				dao.updatePassword(new Member(memberId, newPassword));
				session.commit();
				return "/WEB-INF/view/member/changePasswordSuccess.jsp";
			}
		}
		return null;
	}
}