<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/lhh-tags" prefix="s"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>EL+JSTL</title>
	</head>
	<body>
		<h1>JSTL</h1>
		<!-- 1.if -->
		<p>
			<c:if test="${stu.sex=='M' }">男</c:if>
			<c:if test="${stu.sex=='F' }">女</c:if>
		</p>
		<!-- 2.choose -->
		<p>
			<c:choose>
				<c:when test="${stu.sex=='M' }">男</c:when>
				<c:otherwise>女</c:otherwise>
			</c:choose>
		</p>
		<!-- 3.forEach
			items：声明要遍历的数组或集合
			var：声明每次遍历所获取的数据的名称 -->
		<p>
			<c:forEach items="${stu.interests }" var="i">
				${i }
			</c:forEach>
		</p>
		<!-- 4.自定义标签 -->
		<p>
			<s:sysdate format="yyyy年MM月dd日"/>
		</p>
	
		<h1>EL</h1>
		<!-- 1.获取bean的属性 -->
		<!-- request.getAttribute("stu").getName() -->
		<p>姓名:${stu.name }</p>
		<p>年龄:${stu["age"] }</p>
		<!-- request.getAttribute("stu")
				.getCourse().getId() -->
		<p>课程:${stu.course.id }</p>
		<!-- EL默认从4个内置对象中取值，
			并且它是依次取值，这4个对象叫取值范围：
			page、request、session、application
			也可以明确指定取值范围(了解)：
			如sessionScope.stu.name -->
		<p>性别:${requestScope.stu.sex }</p>
		<!-- 2.对获取到的值进行运算 -->
		<p>年龄+10:${stu.age+10 }</p>
		<p>年龄范围:${stu.age>20 && stu.age<30 }</p>
		<p>判空:${empty stu }</p>
		<!-- 3.获取请求参数 -->
		<p>参数:${param.code }</p>
	</body>
</html>















