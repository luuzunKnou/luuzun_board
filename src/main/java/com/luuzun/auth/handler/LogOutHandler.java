package com.luuzun.auth.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luuzun.controller.CommandHandler;

public class LogOutHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//getSession(true) : 세션이 있다면 리턴, 없으면 새로 생성
		//getSession(false) : 세션이 있다면 리턴, 없다면 null 반환
		HttpSession session = req.getSession(false);
		if(session != null){
			session.invalidate();
		}
		res.sendRedirect(req.getContextPath()+"/index.jsp");
		return null;
	}
}
