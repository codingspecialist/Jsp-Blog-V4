package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;

public class UsersLoginAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 남기는 로직
		
		RequestDispatcher dis = request.getRequestDispatcher("user/login.jsp");
		dis.forward(request, response);
	}
	
}
