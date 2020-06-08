<%@page import="com.cos.blog.dto.DetailResponseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>
	
	<c:if test="${sessionScope.principal.id == dto.board.userId}">
		<a href="/blog/board?cmd=update&id=${dto.board.id}" class="btn btn-warning">수정</a>
		<button class="btn btn-danger">삭제</button>
	</c:if>
	
	<br/><br/>
	<h6>작성자 : <i>${dto.username}</i></h6>
	<br/>
	<h3><b>${dto.board.title}</b></h3>

	<div class="form-group">
		<div class="container p-3 my-3 border">${dto.board.content}</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>