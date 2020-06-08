<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %>

<div class="container">
	
	<form action="/blog/user?cmd=loginProc" method="POST" class="was-validated">
	  
	  <div class="form-group">
	    <label for="username">Username:</label>
	    <input type="text" value="${cookie.remember.value}" class="form-control" id="username" placeholder="Enter username" name="username" required>
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
	      <c:choose>
		      <c:when test="${empty cookie.remember}">
		  		<input class="form-check-input" type="checkbox" name="remember"> 아이디 기억하기    	
		      </c:when>
		      <c:otherwise>
		      	<input class="form-check-input" type="checkbox" name="remember" checked> 아이디 기억하기
		      </c:otherwise>
	      </c:choose>
	      
	    </label>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">로그인</button>
	  
	</form>
</div>

<%@ include file="../include/footer.jsp" %>