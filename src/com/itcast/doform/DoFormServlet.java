package com.itcast.doform;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 处理表单Servlet
 */
public class DoFormServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Boolean flag=isTokenValid(request);
		if (!flag) {
			System.out.println("重复提交");
			return ;
		}
		request.getSession().removeAttribute("token");
		System.out.println("成功注册");
	}

	
	private Boolean isTokenValid(HttpServletRequest request) {
		String client_token=request.getParameter("token");
		String server_token=(String) request.getSession().getAttribute("token");
		if (client_token==null) {
			return false;
		}
		if (server_token==null) {
			return false;
		}
		if (!client_token.equals(server_token) ){
			return false;
		}
		return true;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
