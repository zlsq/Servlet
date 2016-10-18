package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//1.接收请求参数
		//当前业务没有参数需要接收
		//2.使用参数处理业务(查询)
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//3.输出响应信息
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//在此开发模式下写CSS太麻烦了，
		//所以写元素的属性代替。
		//th是特殊的td，自带了居中、加粗的效果。
		out.println("<a href='add_emp.html'>增加</a>");
		out.println("<table width='40%' border='1' cellspacing='0'>");
		out.println("  <tr>");
		out.println("    <th>编号</th>");
		out.println("    <th>姓名</th>");
		out.println("    <th>职位</th>");
		out.println("    <th>薪资</th>");
		out.println("  </tr>");
		if(list != null) {
			for(Emp e : list) {
				out.println("<tr>");
				out.println("  <td>"+e.getEmpno()+"</td>");
				out.println("  <td>"+e.getEname()+"</td>");
				out.println("  <td>"+e.getJob()+"</td>");
				out.println("  <td>"+e.getSal()+"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
	}

	
	
}







