package com.cos.blog.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {

	@Test
	public void hash_test() {
		System.out.println("hash_test");
		String encPassword = new BCryptPasswordEncoder().encode("1234");
		System.out.println("1234 hash:" + encPassword);
	}
}
