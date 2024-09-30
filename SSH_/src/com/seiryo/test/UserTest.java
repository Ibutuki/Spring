package com.seiryo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seiryo.entity.User;
import com.seiryo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class UserTest {
	@Autowired
    private UserService userServiceImp;
	@Test
	public void save() {
		userServiceImp.save(new User(1,"xxx","xxx"));
	}
}
