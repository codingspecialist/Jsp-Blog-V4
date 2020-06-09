package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Users;
import com.cos.blog.repository.UsersRepository;
import com.cos.blog.util.SHA256;
import com.cos.blog.util.Script;

public class UsersLoginProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 유효성 검사
		if
		(
				request.getParameter("username") == null ||
				request.getParameter("username").equals("") ||
				request.getParameter("password") == null ||
				request.getParameter("password").equals("")
				
		) {
			return;
		}
		
		String username = request.getParameter("username");
		String rawPassword = request.getParameter("password");
		String password = SHA256.encodeSha256(rawPassword);
		// System.out.println("UsersLoginProcAction : "+password);
		UsersRepository usersRepository = UsersRepository.getInstance();
		Users user = usersRepository.findByUsernameAndPassword(username, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
			
			
			if(request.getParameter("remember") != null) {
				// key => Set-Cookie
				// value => remember=ssar 
				Cookie cookie = new Cookie("remember", user.getUsername());
				response.addCookie(cookie);
				
				//response.setHeader("Set-Cookie", "remember=ssar");
			}else {
				Cookie cookie = new Cookie("remember", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				
			}
			
			Script.href("로그인 성공", "/blog/board?cmd=home", response);
		}else {
			Script.back("로그인 실패", response);
		}
	}
	
}


