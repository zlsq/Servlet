package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/**
 * 	路径规范:
 * 查询员工: /findEmp.do
 * 增加员工: /addEmp.do
 * @author root
 *
 */
public class MainServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获取请求路径
		String path = req.getServletPath();
		//根据规范处理这些路径
		if("/findEmp.do".equals(path)){
			//查询员工
			findEmp(req,res);
		} else if ("/addEmp.do".equals(path)){
			//增加员工
			addEmp(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
	}
	
	protected void findEmp(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//1.接受请求参数
		//当前业务没有参数需要接收
		//2.使用参数处理业务(查询)
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//3.输出响应信息
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<a href='add_emp.html'>增加</a>");
		out.println("<table width='40%' border='1' cellspacing='0'>");
		out.println("	<tr>");
		out.println("		<th>编号</th>");
		out.println("		<th>姓名</th>");
		out.println("		<th>职位</th>");
		out.println("		<th>薪资</th>");
		out.println("	</tr>");
			
		if(list != null){
			for (Emp e : list) {
				out.println("<tr>");
				out.println("	<td>"+e.getEmpno()+"</td>");
				out.println("	<td>"+e.getEname()+"</td>");
				out.println("	<td>"+e.getJob()+"</td>");
				out.println("	<td>"+e.getSal()+"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");		
	}

	protected void addEmp(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//接收表单数据
		req.setCharacterEncoding("utf-8");
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//保存这些数据
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		if(sal != null && !sal.equals("")){
			e.setSal(new Double(sal));
		}
		EmpDao dao = new EmpDao();
		dao.save(e);
		
		
		//发送响应数据
//		res.setContentType("text/HTML;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("<p>保存成功</p>");
//		out.close();
		//重定向到长沙讯页面
		//重定向:一种特殊的跳转方式
		//当前访问路径:/EmpManager/addEmp
		//目标路径:/EmpManager/findEmp
		res.sendRedirect("findEmp.do");
	}
	
}
