package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

	private Double salary = 2000.0;

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		synchronized(this) {
			salary += 100;
			//模拟网络延迟
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//将结果输出给浏览器
			res.setContentType(
					"text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println(salary);
			out.close();
		}
	}
	
	
	
}










