package com.cos.blog.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void back(String msg, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8"); 
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println("history.back();");
			out.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
