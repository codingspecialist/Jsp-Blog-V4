<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<form id="myForm" action="formTest2.jsp" method="post">
	<input type="text" name="username" id="username"/>
	<input type="text" name="password" id="password"/>
	<button type="button" onclick="test()">전송</button>
</form>

<script>
function test(){
	var form = $("#myForm");
	console.log(form.serialize());

	$.ajax({
		type: "POST",
		url: "formTest2.jsp",
		data: form.serialize(),
		contentType: "application/x-www-form-urlencoded; charset=utf-8"
	}).done(function(){}).fail(function(){});
}
</script>
</body>
</html>