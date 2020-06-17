<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %> 

<div class="container">
	<h1>카카오 로그인 추가 정보 구성창</h1>
	<form action="/blog/oauth/kakao?cmd=joinProc" method="POST" class="was-validated">
	  
	  <div class="form-group">
	    <label for="username">Username:</label>
	
	    <input value="${kakaoProfile.id}_kakao" type="text" class="form-control" id="username" placeholder="Enter username" name="username" required readonly>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="email">Email:</label>
	    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>

	  <button type="submit" class="btn btn-primary">회원가입완료</button>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>

