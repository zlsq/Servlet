package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060852870298693421L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.使用request读取请求数据
		//1.1读取请求行
		System.out.println("请求方式" + req.getMethod());
		System.out.println("访问路径" + req.getServletPath());
		System.out.println("协议类型" + req.getProtocol());		
		//1.2读取消息头
		//getHeaderNames()返回key的迭代器,
		//该迭代器是比Iterator更古老的迭代器.
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String key = (String) e.nextElement();
			String value = req.getHeader(key);
			System.out.println(key + ":" + value);
		}
		//1.3读取实体内容
		//本案例浏览器没有向服务器传递任何业务数据,所以实体内容为空
		//2.使用response写响应数据
		//2.1写状态行: 由服务器自动写
		//2.2写消息头
		//告诉浏览器给它输出的是什么格式的内容
		res.setContentType("text/html");
		
		//获取输出流，该流指向的目标就是浏览器
		PrintWriter out = res.getWriter();
		//省略代码N行
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		//2.3写实体内容	
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>TimeServlet</title>");
		out.println("<meta charset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>"+now+"</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
}




