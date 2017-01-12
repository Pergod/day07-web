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
 * 产生表单Servlet
 */
public class FormServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//产生随机数（令牌）
		String token=TokenProcessor.getInstance().generateToken();
		req.getSession().setAttribute("token", token);
		req.getRequestDispatcher("/do_form.jsp").forward(req, resp);
	}
}
/*
 * 令牌唯一
 */
class TokenProcessor{
	/*单例:
	 * 1.构造方法私有
	 * 2.自己创建
	 * 3.暴露一个方法获取对象
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
			
			//获取数据摘要(数字指纹),防止随机数长度不一。 md5 SHA-1
			MessageDigest messageDigest=MessageDigest.getInstance("MD5");
			byte[]  md5=messageDigest.digest(token.getBytes());
			//base64编码
			BASE64Encoder encoder=new BASE64Encoder();
			
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return token;
	}
}