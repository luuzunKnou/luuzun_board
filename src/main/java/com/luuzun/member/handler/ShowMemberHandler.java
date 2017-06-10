package com.luuzun.member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.controller.CommandHandler;
import com.luuzun.member.model.Member;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;

public class ShowMemberHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String memberId = req.getParameter("memberId");
		Member member;
		try(SqlSession session = MySqlSessionFactory.openSession();){
			MemberDao dao = session.getMapper(MemberDao.class);
			member = dao.selectById(memberId);
		}
		req.setAttribute("member", member);
		return null;
	}

}
