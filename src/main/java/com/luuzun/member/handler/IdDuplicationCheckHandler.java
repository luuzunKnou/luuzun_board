package com.luuzun.member.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.luuzun.controller.CommandHandler;
import com.luuzun.member.model.MemberDao;
import com.luuzun.util.MySqlSessionFactory;
import com.luuzun.util.ResponseByJSON;

public class IdDuplicationCheckHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String memberId = req.getParameter("memberId");

			try(SqlSession session = MySqlSessionFactory.openSession();){
				//이미 존재하는 회원인지 확인
				MemberDao dao = session.getMapper(MemberDao.class);
				Map<String, String> isDuplicate = new HashMap<>();
				
				if(dao.selectById(memberId) != null)
					isDuplicate.put("isDuplicateId", "true");
				else
					isDuplicate.put("isDuplicateId", "false");
				
				ResponseByJSON.getInstance().responseByJSON(res, isDuplicate);
			}
		}
		return null;
	}
}
