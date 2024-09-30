package com.edu.seiryo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edu.seiryo.controller.User;

@Mapper
@Repository
public interface UserMapper {
	List<User> allUsers();
	User getUser(@Param("id")Integer id);
}
