<%@page import="java.io.PrintWriter"%>
<%@page import="com.cos.blog.model.Users"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="include/nav.jsp"%>

<div class="container">

	<div class="col-md-12 m-2">
		<form class="form-inline justify-content-end" action="/blog/board">
			<input type="hidden" name="cmd" value="search" />
			<input type="hidden" name="page" value="0" />
			<input type="text" name="keyword" class="form-control mr-sm-2" placeholder="Search">			
			<button class="btn btn-primary">검색</button>
		</form>
	</div>

	<div class="progress col-md-12 m-2">
		<div class="progress-bar" style="width: ${currentPercent}%"></div>
	</div>

	<c:forEach var="board" items="${boards}">
		<div class="card col-md-12 m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<p class="card-text">${board.content}</p>
				<a href="/blog/board?cmd=detail&id=${board.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>

	<br />

	<%@ include file="include/paging.jsp"%>

</div>

<%@ include file="include/footer.jsp"%>
