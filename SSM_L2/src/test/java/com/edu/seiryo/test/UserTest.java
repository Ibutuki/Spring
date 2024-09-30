package com.edu.seiryo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.seiryo.pojo.Users;
import com.edu.seiryo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
	@Autowired
	UserService userService;
	@Test
	public void queryAll() {
		userService.queryAll();
	}
	@Test
	public void get() {
		userService.get(2);
	}
	@Test
	public void toAddUser() {
		userService.toAddUser(new Users(34,"111","222"));
	}
	@Test
	public void queryUser() {
		userService.queryUser("123");
	}
	@Test
	public void update() {
		userService.update(new Users(34,"111","444"));
	}
	@Test
	public void del() {
		userService.del(1);
	}
}
