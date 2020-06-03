<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// page -> request -> session -> application
	request.setAttribute("username", "ssar");
	session.setAttribute("username", "1234");
	RequestDispatcher dis =
			request.getRequestDispatcher("elTest2.jsp");
	dis.forward(request, response);
%>