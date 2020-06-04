<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %> 

<div class="container">
	<form action="/blog/user?cmd=joinProc" method="POST" class="was-validated" onsubmit="return validate()">
	  
	  <div class="form-group">
	    <label for="username">Username:</label>
	    <button type="button" class="btn btn-warning float-right" onclick="usernameCheck()">중복확인</button>
	    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="pwd">Password:</label>
	    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="email">Email:</label>
	    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <div class="form-group">
   		<label for="address">Address:</label>
   		<button type="button" class="btn btn-warning float-right" onclick="goPopup()">주소검색</button>
    	
	    <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address" required readonly>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>

	  <button type="submit" class="btn btn-primary">회원가입완료</button>
	</form>
</div>

<script src="${path}/js/join.js"></script>
<%@ include file="../include/footer.jsp" %>

