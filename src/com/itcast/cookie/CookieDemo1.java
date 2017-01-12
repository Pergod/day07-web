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
		 * ��Ϊ�ǵ��������ת�����ģ������൱���������󣬲���ͨ��req.getCookies��ȡ
		 */
		//���Ʊ���һ��
		Cookie cookie=new Cookie("lastAccess", System.currentTimeMillis()+"");
		cookie.setMaxAge(0);
		//path����һ��
		cookie.setPath("/day07");
		
		resp.addCookie(cookie);
//		resp.sendRedirect("/day07/time");
	}
}
