package com.cos.blog.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dto.BoardResponseDto;
import com.cos.blog.dto.DetailResponseDto;
import com.cos.blog.dto.ReplyResponseDto;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.util.HtmlParser;
import com.cos.blog.util.Script;

public class BoardDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(
				request.getParameter("id") == null || 
				request.getParameter("id").equals("")
		  ) {
			Script.back("잘못된 접근입니다.", response);
			return;
		}
		
		int boardId = Integer.parseInt(request.getParameter("id"));
		BoardRepository boardRepository = 
				BoardRepository.getInstance();
		ReplyRepository replyRepository =
				ReplyRepository.getInstance();
		
		//조회수 증가가 상세보기가 되기 전에 실행되는 것이 좋음
		int result = boardRepository.updateReadCount(boardId);
		
		if(result != 1) {
			Script.back("서버 오류!", response);
			return;
		}
		
		// Board, User (해당 게시물의 글과 작성자)
		BoardResponseDto boardDto = 
				boardRepository.findById(boardId);
		
		// Reply, User (해당 게시물의 댓글과 댓글의 작성자) 복수
		List<ReplyResponseDto> replyDtos = 
				replyRepository.findAll(boardId);
		
		DetailResponseDto detailDto = 
				DetailResponseDto.builder()
					.boardDto(boardDto)
					.replyDtos(replyDtos)
					.build();
		
		if(detailDto != null) {
			// 유튜브 파싱하기
			String content = boardDto.getBoard().getContent();
			content = HtmlParser.getContentYoutube(content);
			boardDto.getBoard().setContent(content);
			
			request.setAttribute("detailDto", detailDto);
			RequestDispatcher dis = 
					request.getRequestDispatcher("board/detail.jsp");
			dis.forward(request, response);
		} else {
			Script.back("잘못된 접근입니다.", response);
		}
	}
}








