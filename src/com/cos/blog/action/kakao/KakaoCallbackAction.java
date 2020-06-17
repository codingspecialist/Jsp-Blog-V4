package com.cos.blog.action.kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dto.KakaoProfile;
import com.cos.blog.model.OAuthToken;
import com.cos.blog.model.Users;
import com.cos.blog.repository.UsersRepository;
import com.cos.blog.util.Script;
import com.google.gson.Gson;

public class KakaoCallbackAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String grant_type = "authorization_code";
		String client_id = "8e2497fd846ea6b62b1ee5ce66a1b20b";
		String redirect_uri = "http://localhost:8000/blog/oauth/kakao?cmd=callback";
				
		// POST요청, x-www-form-urlencoded
		String endpoint = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(endpoint);
		
		String bodyData="";
		bodyData += "grant_type=authorization_code&";
		bodyData += "client_id=8e2497fd846ea6b62b1ee5ce66a1b20b&";
		bodyData += "redirect_uri=http://localhost:8000/blog/oauth/kakao?cmd=callback&";
		bodyData += "code="+code;
		
		// Stream 연결
		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		// http header 값 넣기
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		// request 하기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
		bw.write(bodyData);
		bw.flush();
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String input = "";
		StringBuilder sb = new StringBuilder();
		while((input = br.readLine()) != null) {
			sb.append(input);
		}
		System.out.println(sb.toString());
		// Gson으로 파싱
		Gson gson = new Gson();
		OAuthToken oAuthToken = 
				gson.fromJson(sb.toString(), OAuthToken.class);
		
		
		
		
		// Profile 받기 (Resource Server)
		String endpoint2 = "https://kapi.kakao.com/v2/user/me";
		URL url2 = new URL(endpoint2);
		
		HttpsURLConnection conn2 = (HttpsURLConnection)url2.openConnection();
		// http header 값 넣기
		conn2.setRequestProperty("Authorization", "Bearer "+oAuthToken.getAccess_token());
		conn2.setDoOutput(true);
		// request 하기
		BufferedReader br2 = new BufferedReader(
				new InputStreamReader(conn2.getInputStream(), "UTF-8"));
		String input2 = "";
		StringBuilder sb2 = new StringBuilder();
		while((input2 = br2.readLine()) != null) {
			sb2.append(input2);
		}
		System.out.println(sb2.toString());
		// Gson으로 파싱
		Gson gson2 = new Gson();
		KakaoProfile kakaoProfile = 
				gson2.fromJson(sb2.toString(), KakaoProfile.class);
		
		if(kakaoProfile.getKakao_account().isHas_email() == true) {
			System.out.println("회원가입 진행하기");
			UsersRepository usersRepository = 
					UsersRepository.getInstance();
			String username = kakaoProfile.getKakao_account().getEmail();
			username += "_kakao";
			Users user = Users.builder()
					.username(username)
					.email(kakaoProfile.getKakao_account().getEmail())
					.build();
			int result = usersRepository.findByUsername(username);
			
			if(result != 1) {
				usersRepository.save(user);
			}
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
				
			Script.href("카카오 로그인 완료", "/blog/index.jsp", response);
		}else {
			System.out.println("회원가입 창으로 이동하여 email 사용자로 부터 받기");
		}
		
	}
}
