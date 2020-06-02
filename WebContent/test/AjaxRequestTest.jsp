<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	div {
		border: 1px solid black;
		margin: 5px;
		padding: 5px;
	}
</style>
</head>
<body>
<div id="reply-box">
	<div id="reply-1">
		첫번째 댓글입니다.	
	</div>
</div>
<input type="text" id="tf-reply" /> <br/>
<button onclick="start()">댓글쓰기</button>
<script>
var num = 1;
function start() {
	num++;
	var a = $('#tf-reply').val();

	var data = {
		username:"ssar",
		content:a
	};
	
	// 통신이 성공하면 아래 로직 실행

	
	$.ajax({
		type: 'POST',
		url: 'AjaxResponseTest.jsp', // 필수값
		data: JSON.stringify(data), // 보내는 데이터
		contentType: 'application/json; charset=utf-8',
		dataType: 'json' // 받을 데이터를 어떻게 파싱할까를 정의 text, json
	}).done(function(result){
		console.log(result);
		$('#reply-box').prepend("<div id='reply-"+num+"'>"+a+"</div>");
	}).fail(function(error){
		console.log('에러났어');
		console.log(error);
	});

	
	
}
</script>
</body>
</html>