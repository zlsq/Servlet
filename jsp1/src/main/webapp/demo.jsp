<%@page pageEncoding="utf-8"%>
<!-- 1.先写HTML -->
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>第1个JSP</title>
	</head>
	<body>
		<!-- 2.再写Java -->
		<!-- 2.3JSP声明(声明方法) -->
		<%!
			public int pf(int n) {
				return n*n;
			}
		%>
		<ul>
			<!-- 2.1JSP脚本(完整的代码段) -->
			<%
				for(int i=0;i<10;i++) {
			%>
				<!-- 2.2JSP表达式(输出变量) -->
				<li><%=pf(i) %></li>
			<%
				}
			%>
		</ul>
		<!-- 引入date.jsp，相当于将date.jsp
			中的内容复制到此处。 -->
		<%@include file="date.jsp" %>
	</body>
</html>
























