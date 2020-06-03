<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// String email = request.getParameter("email");
	BufferedReader br = request.getReader();
	
	String input = null;
	StringBuilder sb = new StringBuilder();
	while((input = br.readLine()) != null){
		sb.append(input);
		System.out.println(input);
	}
	String email = sb.toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>elTest4.jsp</h1>
<hr/>
이메일 : <%=email %>
</body>
</html>