package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class AddEmpServlet extends  HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
		res.sendRedirect("findEmp");
	}
	
}
