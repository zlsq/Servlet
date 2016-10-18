<!-- 本JSP并不独立使用，而是被其他JSP引用。 -->
<!-- 
pageEncoding:
	设置此文件的编码，在tomcat读取此文件时使用。
contentType:
	tomcat调用此JSP给浏览器拼网页时，通知
	浏览器输出的格式及编码。
import:
	将指定的类引入到JSP上使用。
-->
<%@page pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"
	import="java.util.*,java.text.*"%>
<%
	Date date = new Date();
	SimpleDateFormat sdf = 
		new SimpleDateFormat("HH:mm:ss");
	String now = sdf.format(date);
%>
<p><%=now %></p>










