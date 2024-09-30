package com.edu.seiryo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.seiryo.pojo.User;
@SpringBootTest
public class TestDemo {
	@Autowired
	User user;
	@Test
	public void test() {
		System.out.println(user);
	}
}