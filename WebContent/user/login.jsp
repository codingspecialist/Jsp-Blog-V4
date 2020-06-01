<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %>

<%
	String remember = (String) request.getAttribute("remember");

	if(remember == null){
		remember = "";
	}
%>

<div class="container">
	
	<form action="/blog/user?cmd=loginProc" method="POST" class="was-validated">
	  
	  <div class="form-group">
	    <label for="username">Username:</label>
	    <input type="text" value="<%=remember %>" class="form-control" id="username" placeholder="Enter username" name="username" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox" name="remember" required> 아이디 기억하기
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Check this checkbox to continue.</div>
	    </label>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">로그인</button>
	  
	</form>
</div>

<%@ include file="../include/footer.jsp" %>