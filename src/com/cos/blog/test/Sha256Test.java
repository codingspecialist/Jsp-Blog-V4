package com.cos.blog.test;

import java.security.MessageDigest;

import org.junit.Test;

public class Sha256Test {

private final static String salt = "코스";
	
	@Test
	public void encSha256() {
		String plain = "1234";
		String result = "";
		
		byte[] bytePlain = plain.getBytes();
		byte[] byteSalt = salt.getBytes();
		
		for (byte b : bytePlain) {
			System.out.print(b+" ");
		}
		System.out.println();
		
		for (byte b : byteSalt) {
			System.out.print(b+" ");
		}
		
		byte[] bytePlainAndSalt = 
				new byte[bytePlain.length+byteSalt.length];
		System.arraycopy
		(
				bytePlain, 
				0, 
				bytePlainAndSalt, 
				0, 
				bytePlain.length
		);
		System.arraycopy
		(
				byteSalt, 
				0, 
				bytePlainAndSalt, 
				bytePlain.length, 
				byteSalt.length
		);
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytePlainAndSalt);
			
			byte[] byteData = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toHexString((byteData[i] & 0xFF)+256).substring(1));
			}
			System.out.println();
			result = sb.toString();
			System.out.println(result);
		} catch (Exception e) {
			
		}
		
		
	}
	
	//@Test
	public void 진수_Test() {
		byte b = 35;
		System.out.println(Integer.toHexString((b & 0xFF)+256).substring(1));
		

	}
}
