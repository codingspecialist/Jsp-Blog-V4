package com.cos.blog.action.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.util.Script;

public class ReplyDeleteProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("replyId") == null ||
				request.getParameter("replyId").equals("")) {
			return;
		}
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		System.out.println("ReplyDeleteProcAction : replyId : "+replyId);
		
		ReplyRepository replyRepository = 
				ReplyRepository.getInstance();
		int result = replyRepository.deleteById(replyId);
		Script.outText(result+"", response);
	}
}
