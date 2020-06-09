<%@page import="java.io.PrintWriter"%>
<%@page import="com.cos.blog.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/nav.jsp" %>

<div class="container">

	<c:forEach var="board" items="${boards}">
		<div class="card m-2" style="width:100%">
		  <div class="card-body">
		    <h4 class="card-title">${board.title}</h4>
		    <p class="card-text">${board.content}</p>
		    <a href="/blog/board?cmd=detail&id=${board.id}" class="btn btn-primary">상세보기</a>
		  </div>
		</div>
	</c:forEach>
	
	<br/>
	
	<!-- disabled -->
	<ul class="pagination justify-content-center">
	  <li class="page-item"><a class="page-link" href="/blog/board?cmd=home&page=${param.page-1}">Previous</a></li>
	  <li class="page-item"><a class="page-link" href="/blog/board?cmd=home&page=${param.page+1}">Next</a></li>
	</ul>

</div>

<%@ include file="include/footer.jsp" %>
    