package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {
	
	//1.默认首次访问时实例化
	//2.修改配置后在启动tomcat时实例化
	public HiServlet() {
		System.out.println("实例化HiServlet");
	}

	//在实例化Servlet后由tomcat自动调用
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("初始化HiServlet");
	}

	//每次访问都可以调用
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		System.out.println("调用HiServlet");
	}

	//正常关闭tomcat时调用销毁
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁HiServlet");
	}
	
	
	
}
















