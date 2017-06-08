package com.luuzun.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

public class ResponseByJSON {
	private static final ResponseByJSON instance = new ResponseByJSON();
	public ResponseByJSON() {}
	public static ResponseByJSON getInstance() {
		return instance;
	}
	
	public void responseByJSON(HttpServletResponse res, Object object){
		res.setContentType("application/json;charset=utf-8");//보낼 데이터가 json임을 명시함
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writeValueAsString(object); //객체의 값을 json string으로 변환
			PrintWriter pw = res.getWriter();
			pw.print(json);// response에 json String을 넣음
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
