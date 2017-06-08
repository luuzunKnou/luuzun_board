package com.luuzun.member.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.controller.CommandHandler;
import com.luuzun.member.model.Member;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;
import com.luuzun.util.ResponseByJSON;

public class ShowMemberListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		try(SqlSession session = MySqlSessionFactory.openSession();){
			MemberDao dao = session.getMapper(MemberDao.class);
			List<Member> memberList = dao.selectByAll();
			ResponseByJSON.getInstance().responseByJSON(res, memberList);
		}
		return null;
	}
}
