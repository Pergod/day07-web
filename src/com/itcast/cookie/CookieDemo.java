package com.itcast.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer=resp.getWriter();
		writer.write("�ϴη���ʱ��:");
		writer.write("<a href='/day07/delete'>���<a> <br/>");
		//��ȡcookie
		Cookie[] time=req.getCookies();
		if (time!=null) {
			for (Cookie cookie : time) {
				if (cookie.getName().equals("lastAccess")) {
					Long value=Long.parseLong(cookie.getValue());
					Date date=new Date(value);
					writer.write(date.toLocaleString());
				}
			}
		}
		
		//��������cookie
		Cookie lastAccess=new Cookie("lastAccess", System.currentTimeMillis()+"");
		lastAccess.setMaxAge(3600);
		lastAccess.setPath("/day07");
		resp.addCookie(lastAccess);
	}
}
