<%@page import="com.google.gson.Gson"%>
<%@page import="com.cos.blog.dto.ResponseDto"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// { "username":"ssar", "content": "두번째 댓글입니다"}
	BufferedReader br = request.getReader();

	String input = null;
	StringBuilder sb = new StringBuilder();
	while((input = br.readLine()) != null){
		sb.append(input);
	}
	System.out.println("받은 데이터 시작--------------");
	System.out.println(sb.toString());
	System.out.println("받은 데이터 끝--------------");
	
	ResponseDto<String> dto = new ResponseDto<>();
	dto.setStatus(200);
	dto.setData("성공");
	
	Gson gson = new Gson();
	String returnStr = gson.toJson(dto);
	System.out.println(returnStr);
	
	out.println(returnStr);
%>
