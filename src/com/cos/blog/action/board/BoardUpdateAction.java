package com.cos.blog.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dto.BoardResponseDto;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.util.Script;

public class BoardUpdateAction implements Action{
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
		BoardResponseDto boardDto = 
				boardRepository.findById(id);
		if(boardDto != null) {
			request.setAttribute("boardDto", boardDto);
			RequestDispatcher dis = 
					request.getRequestDispatcher("board/update.jsp");
			dis.forward(request, response);
		}else {
			Script.back("잘못된 접근입니다.", response);
		}
		
	}
}
