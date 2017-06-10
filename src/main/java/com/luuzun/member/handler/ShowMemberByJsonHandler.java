package com.luuzun.member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.controller.CommandHandler;
import com.luuzun.member.model.Member;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;
import com.luuzun.util.ResponseByJSON;

public class ShowMemberByJsonHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String memberId = req.getParameter("memberId");
		Member member;
		try(SqlSession session = MySqlSessionFactory.openSession();){
			MemberDao dao = session.getMapper(MemberDao.class);
			member = dao.selectById(memberId);
		}

		ResponseByJSON.getInstance().responseByJSON(res, member);
		return null;
	}

}
