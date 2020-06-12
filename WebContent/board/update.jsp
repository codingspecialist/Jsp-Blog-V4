<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<%@ include file="../include/authentication.jsp"%>

<div class="container">
	<form action="/blog/board?cmd=updateProc" method="POST">
	
		<input type="hidden" value="${boardDto.board.id}" name="id"/>
		<div class="form-group">
			<label for="title">Title:</label>
			<input value="${boardDto.board.title}" type="text" class="form-control" placeholder="title" id="title" name="title">
		</div>
	
		<div class="form-group">
			<label for="content">Content:</label>
			<textarea id="summernote" class="form-control" rows="5" id="content" name="content">
				${boardDto.board.content}
			</textarea>
		</div>
	
		<button type="submit" class="btn btn-primary">수정하기</button>
	</form>
</div>

<script>
  $(document).ready(function() {
      $('#summernote').summernote({
    	  tabsize: 2,
          height: 300
      });
  });
</script>
<%@ include file="../include/footer.jsp"%>