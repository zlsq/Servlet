<%@page pageEncoding="utf-8"
	import="java.util.*,entity.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>员工查询</title>
	</head>
	<body>
		<table border="1" width="40%" cellspacing="0">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>职位</th>
				<th>薪资</th>
			</tr>
			<%
				//转发时Servlet将数据绑定到request上，
				//并将request转发给了JSP，所以此处
				//可以直接通过request获得绑定的数据。
				List<Emp> list = (List<Emp>)
					request.getAttribute("emps");
				if(list != null) {
					for(Emp e : list) {
			%>
					<tr>
						<td><%=e.getEmpno() %></td>
						<td><%=e.getEname()%></td>
						<td><%=e.getJob() %></td>
						<td><%=e.getSal() %></td>
					</tr>
			<%			
					}
				}
			%>
		</table>
	</body>
</html>










