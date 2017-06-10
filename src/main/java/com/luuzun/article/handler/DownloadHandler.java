package com.luuzun.article.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luuzun.controller.CommandHandler;

public class DownloadHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String fileName = req.getParameter("filename");
		String filePath = req.getSession().getServletContext().getRealPath("/upload/")+fileName;
		System.out.println(fileName + " : "+ filePath);

		File downfile = new File(filePath);

		if(!downfile.exists()) {
			System.out.println("파일이 없습니다.");
			return null;
		}

		ServletOutputStream outStream = null;
		FileInputStream inputStream = null;

		try {
			outStream = res.getOutputStream();
			inputStream = new FileInputStream(downfile);               

			//Setting Resqponse Header
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition",                     
					"attachment;filename=\""+downfile.getName()+"\"");

			//Writing InputStream to OutputStream
			byte[] outByte = new byte[4096];
			while(inputStream.read(outByte, 0, 4096) != -1)	{
				outStream.write(outByte, 0, 4096);
			}
		} catch (Exception e) {
			throw new IOException();
		} finally {
			inputStream.close();
			outStream.flush();
			outStream.close();
		}
		return null;
	}
}
