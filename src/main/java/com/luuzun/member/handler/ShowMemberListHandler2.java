package com.luuzun.member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luuzun.controller.CommandHandler;

public class ShowMemberListHandler2 implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "/WEB-INF/view/member/showMemberList.jsp";
	}
}
