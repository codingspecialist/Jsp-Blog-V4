<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>elTest6.jsp</h1>
<hr/>
<%
	// 10000
	String money = request.getParameter("money");
%>
<script>
	var num = 100;
	var m = '${param.money}';
	console.log(m);

	var sum = num+'${param.money}';
	console.log(sum);
</script>


</body>
</html>



