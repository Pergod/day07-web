package com.itcast.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 因为是点击链接跳转过来的，所以相当于两次请求，不能通过req.getCookies获取
		 */
		//名称必须一致
		Cookie cookie=new Cookie("lastAccess", System.currentTimeMillis()+"");
		cookie.setMaxAge(0);
		//path必须一致
		cookie.setPath("/day07");
		
		resp.addCookie(cookie);
//		resp.sendRedirect("/day07/time");
	}
}
