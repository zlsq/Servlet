package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 一般web项目中都有一个InitServlet，
 * 它不干正事，仅仅是在tomcat启动时
 * 初始化一些数据。
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//向context中存一个变量count=0，
		//给其他servlet使用。
		ServletContext ctx = 
			getServletContext();
		ctx.setAttribute("count", 0);
	}

	
	
}









