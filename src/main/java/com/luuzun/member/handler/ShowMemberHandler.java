package com.luuzun.member.handler;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;

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
		//req.setAttribute("member", member);

		res.setContentType("application/json;charset=utf-8");//보낼 데이터가 json임을 명시함
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(member);//객체의 값을 json string으로 변환
		PrintWriter pw = res.getWriter();
		pw.print(json);// response에 json String을 넣음
		pw.flush();
		
		return null;
	}

}
