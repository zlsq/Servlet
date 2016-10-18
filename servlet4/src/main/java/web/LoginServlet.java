package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	//tomcat在创建此Servlet前会给它单独
	//创建一个config对象，该对象只给此
	//Servlet自己使用，其他Servlet无法访问。
	//并且在调用此Servlet的init()时，将
	//这个config对象传入。config被tomcat创建
	//后已经自动读取了web.xml中的参数。
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String maxOnline = 
			config.getInitParameter("maxOnline");
		System.out.println(maxOnline);
	}

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//1.接收传入的账号密码
		System.out.println("接收账号密码");
		//2.验证账号密码是否正确
		System.out.println("验证账号密码");
		//3.判断当前在线人数是否达上限
		ServletConfig config = getServletConfig();
		String maxOnline = 
			config.getInitParameter("maxOnline");
		System.out.println(maxOnline);
		//4.进入游戏/排队
		System.out.println("进入游戏...");
		
		//统计网站流量
		ServletContext ctx = 
			getServletContext();
		Integer count = (Integer)
			ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println(count);
	}

	
	
}







