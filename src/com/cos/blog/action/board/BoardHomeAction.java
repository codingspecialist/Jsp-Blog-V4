package com.cos.blog.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;

public class BoardHomeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DB연결해서 Board 목록 다 불러와서
		
		// 2. request에 담고
		
		// 3. 이동 home.jsp
		RequestDispatcher dis = 
				request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
	}
}
