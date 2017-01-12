package com.itcast.doform;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
/*
 * ������Servlet
 */
public class FormServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��������������ƣ�
		String token=TokenProcessor.getInstance().generateToken();
		req.getSession().setAttribute("token", token);
		req.getRequestDispatcher("/do_form.jsp").forward(req, resp);
	}
}
/*
 * ����Ψһ
 */
class TokenProcessor{
	/*����:
	 * 1.���췽��˽��
	 * 2.�Լ�����
	 * 3.��¶һ��������ȡ����
	*/
	private static final TokenProcessor instance=new TokenProcessor();
	
	private TokenProcessor(){
		
	}
	
	public static TokenProcessor getInstance() {
		return instance;
	}
	
	public String generateToken(){
		String token=System.currentTimeMillis()+new Random().nextInt()+"";
		try {
			
			//��ȡ����ժҪ(����ָ��),��ֹ��������Ȳ�һ�� md5 SHA-1
			MessageDigest messageDigest=MessageDigest.getInstance("MD5");
			byte[]  md5=messageDigest.digest(token.getBytes());
			//base64����
			BASE64Encoder encoder=new BASE64Encoder();
			
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return token;
	}
}