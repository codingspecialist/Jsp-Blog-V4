<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty param.keyword}">
		<c:set var="pageAddr" 
		value="/blog/board?cmd=home&page=${param.page+1}"/>	
	</c:when>
	<c:otherwise>
		<c:set var="pageAddr" 
		value="/blog/board?cmd=search&page=${param.page+1}&keyword=${param.keyword}"/>
	</c:otherwise>
</c:choose> 
<h1>만들어진 변수 확인</h1>
<hr/>
<h3><c:out value="${pageScope.pageAddr}" /></h3>
</body>
</html>



