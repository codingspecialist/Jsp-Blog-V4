function replyWrite(boardId, userId){
	var data = {
		boardId: boardId,
		userId: userId,
		content: $("#reply__write__form").val()
	};
	
	$.ajax({
		type: "post",
		url: "/blog/reply?cmd=writeProc",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(result){
		if(result == -1 || result == 0){
			alert("댓글 작성 실패");
		}else{
			alert("댓글 작성 성공");
			$("#reply__list").empty();
			console.log(result);
			renderReplyList(result);
			$("#reply__write__form").val("");
		}
	}).fail(function(error){
		alert("댓글 작성 실패");
	});
}

function renderReplyList(replyDtos){
	for(var replyDto of replyDtos){
		$("#reply__list").append(makeReplyItem(replyDto));
	}
}

function makeReplyItem(replyDto){
	var replyItem = `<li class="media">`;
	if(replyDto.userProfile == null){
		replyItem += `<img src="/blog/image/userProfile.png" class="img-circle">`;	
	}else{
		replyItem += `<img src="${replyDto.userProfile}" class="img-circle">`;
	}
	
	replyItem += `<div class="media-body">`;
	replyItem += `<strong class="text-primary">${replyDto.username}</strong>`;
	replyItem += `<p>${replyDto.reply.content}</p>`;
	replyItem += `</div>`;
	replyItem += `</li>`;
	return replyItem;
}