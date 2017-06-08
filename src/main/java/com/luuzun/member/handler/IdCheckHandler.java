package com.luuzun.member.handler;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;

import com.luuzun.controller.CommandHandler;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;

public class IdCheckHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String memberId = req.getParameter("memberId");

			try(SqlSession session = MySqlSessionFactory.openSession();){
				//이미 존재하는 회원인지 확인
				MemberDao dao = session.getMapper(MemberDao.class);
				Map<String, String> isDuplicate = new HashMap<>();
				
				if(dao.selectById(memberId) != null){
					isDuplicate.put("isDuplicateId", "true");
				} else {
					isDuplicate.put("isDuplicateId", "false");
				};
				
				res.setContentType("application/json;charset=utf-8");//보낼 데이터가 json임을 명시함
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(isDuplicate);//객체의 값을 json string으로 변환
				PrintWriter pw = res.getWriter();
				pw.print(json);// response에 json String을 넣음
				pw.flush();
			}
		}else if(req.getMethod().equalsIgnoreCase("post")){

		}
		return null;
	}
}
