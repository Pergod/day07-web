package com.itcast.checkcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//防止乱码
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		//校验验证码
		Boolean flag=checkImageCode(req);
		if (flag) {
			System.out.println("校验通过");
		}else{
			System.out.println("校验失败");
		}
	}
	
	private Boolean checkImageCode(HttpServletRequest req) {
		String client_code=req.getParameter("checkcode");
		String server_code=(String) req.getSession(false).getAttribute("image_code");
		System.out.println("client_code="+client_code);
		System.out.println("server_code="+server_code);
		if (client_code==null) {
			return false;
		}
		if (server_code==null) {
			return false;
		}
		if (!client_code.equals(server_code)) {
			return false;
		}
		return true;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
