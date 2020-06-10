<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${empty sessionScope.backKeyword}">
		<a class="btn btn-secondary" href="/blog/board?cmd=home&page=${sessionScope.backPage}">뒤로가기</a>
	</c:when>
	<c:otherwise>
		<a class="btn btn-secondary" href="/blog/board?cmd=home&page=${sessionScope.backPage}&keyword=${sessionScope.backKeyword}">뒤로가기</a>
	</c:otherwise>
</c:choose>
