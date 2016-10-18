package web;

import java.io.IOException;
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
		HttpServletResponse res) 
		throws ServletException, IOException {
		//查询所有的员工
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//转发给JSP
		//将数据绑定到request上
		req.setAttribute("emps", list);
		//将请求及数据转发给JSP
		//当前：/jsp1/findEmp
		//目标：/jsp1/emps.jsp
		req.getRequestDispatcher(
			"emps.jsp").forward(req, res);
	}

	
	
}
















