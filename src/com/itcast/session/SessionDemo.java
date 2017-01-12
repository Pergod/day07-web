package com.itcast.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * Cookie禁用时,URL重写
 */
public class SessionDemo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.setAttribute("product", "手机");
		
		String sessionId=session.getId();
		Cookie cookie=new Cookie("JSESSIONID", sessionId);
		cookie.setPath("/day07");
		cookie.setMaxAge(30*60);
		resp.addCookie(cookie);
//		session.invalidate();
	}
}
