package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取访问路径
		System.out.println(
			req.getContextPath());
		System.out.println(
			req.getServletPath());
		System.out.println(
			req.getRequestURI());
		System.out.println(
			req.getRequestURL());
		//如果不给浏览器写响应信息，
		//则服务器在响应时实体内容为空，
		//但状态行、消息头有值。此时，
		//浏览器看到的将是一片空白。
	}

	
	
}






