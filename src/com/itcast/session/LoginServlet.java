package com.itcast.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		List<User> users=DB.getAll();
		for (User user : users) {
			if ((user.getUsername().equals(username))&&(user.getPassword().equals(password))) {
				HttpSession session=req.getSession();
				session.setAttribute("user", user);
				resp.sendRedirect("/day07/success.jsp");
				return;
			}
		}
		out.write("µÇÂ½Ê§°Ü");
//		resp.sendRedirect("/day07/login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
class DB{
	private static List<User> users=new ArrayList<User>();
	static{
		users.add(new User("ÀîÀÚ", "123"));
		users.add(new User("Ð¡Ã÷", "123"));
		users.add(new User("º«Ã·Ã·", "123"));
	}
	public static List<User> getAll() {
		return users;
	}
}
class User{
	private String username;
	private String password;
	public User() {
		
	}
	public User(String username,String password) {
		this.username=username;
		this.password=password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}