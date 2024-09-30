package com.seiryo.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seiryo.entity.UserInfo;
import com.seiryo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class UserTest {
	@Autowired
    private UserService userServiceImp;
	@Test
	public void login() {
		UserInfo user1 = new UserInfo();
		user1.setUsePassword("pass01");
		user1.setUserName("user01");
		UserInfo user = userServiceImp.login(user1);
		System.out.println(user);
	}
}
