package com.cos.blog.test;

import org.junit.Test;

import com.cos.blog.db.DBConn;

public class DBConnTest {
	
	@Test
	public void 데이터베이스_연결_테스트() {
		DBConn.getConnection();
	}
}
