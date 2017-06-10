package com.luuzun.member.handler;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;

import com.luuzun.controller.CommandHandler;
import com.luuzun.jdbc.JdbcUtil;
import com.luuzun.member.model.Member;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;

public class JoinHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/member/JoinForm.jsp";
		} else if(req.getMethod().equalsIgnoreCase("post")) {
			Member member = new Member(
					req.getParameter("memberId"), 
					req.getParameter("memberName"), 
					req.getParameter("memberPassword"), 
					new Date());
			
			try(SqlSession session = MySqlSessionFactory.openSession();){
				MemberDao dao = session.getMapper(MemberDao.class);
				dao.insert(member);
				session.commit();
			}
			req.setAttribute("member", member);
			return "/WEB-INF/view/member/JoinSuccess.jsp";
		}
		return null;
	}
}
