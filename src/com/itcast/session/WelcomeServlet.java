package com.itcast.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=req.getSession();
		PrintWriter out=resp.getWriter();
		
		String url1=resp.encodeURL("/day07/buy");
		String url2=resp.encodeURL("/day07/pay");
		
		out.write("<a href='"+url1+"'>π∫¬Ú</a><br/>");
		out.write("<a href='"+url2+"'>Ω·À„</a><br/>");
	}
}
