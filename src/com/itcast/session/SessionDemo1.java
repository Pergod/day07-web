package com.itcast.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//购物车需求时，无需再创建Session。(性能优化)
		HttpSession session=req.getSession(false);
		String product=(String) session.getAttribute("product");
		System.out.println(product);
	}
}
