package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDeptServlet extends HttpServlet {

	//tomcat启动时已经创建了context，
	//并使用它读取了web.xml中的参数。
	//用户访问此查询功能时就可以从context
	//里读取出这个参数了。
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		ServletContext context = 
			getServletContext();
		String size = 
			context.getInitParameter("size");
		System.out.println(size);
		System.out.println("分页查询部门");
		
		//统计网站流量
		ServletContext ctx = 
			getServletContext();
		Integer count = (Integer)
			ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println(count);
		
	}

	
	
}






