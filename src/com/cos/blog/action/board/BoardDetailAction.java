package com.cos.blog.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dto.DetailResponseDto;
import com.cos.blog.repository.BoardRepository;
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		BoardRepository boardRepository = 
				BoardRepository.getInstance();
		
		//조회수 증가가 상세보기가 되기 전에 실행되는 것이 좋음
		int result = boardRepository.updateReadCount(id);
		
		if(result != 1) {
			Script.back("서버 오류!", response);
			return;
		}
		DetailResponseDto dto = 
				boardRepository.findById(id);
		
		if(dto != null) {
			// 유튜브 파싱하기
			String content = dto.getBoard().getContent();
			content = HtmlParser.getContentYoutube(content);
			dto.getBoard().setContent(content);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = 
					request.getRequestDispatcher("board/detail.jsp");
			dis.forward(request, response);
		} else {
			Script.back("잘못된 접근입니다.", response);
		}
	}
}








