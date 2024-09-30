package com.edu.seiryo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class JdbcConntroller {
	@Autowired
	JdbcTemplate jdbcTemlate;
	@GetMapping("/list")
	public List<Map<String, Object>> userList(){
		String sql = "select * from employee";
		List<Map<String, Object>> maps = jdbcTemlate.queryForList(sql);
		return maps;
	}
	
	@GetMapping("/add")
	public String addUser() {
		String sql =  "insert into t_user(t_id,t_name,t_password)" +
		" values (12,'好的是', '123')";
		jdbcTemlate.update(sql);
		return "addOk";
	}
	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id) {
		String sql = "update t_user set t_name ?,t_password = ?"
				+ "where t_id = ?";
		Object[] objects = new Object[2];
		objects[0] = "生物";
		objects[1] = "1332121";
		objects[1] = "2";
		jdbcTemlate.update(sql, objects);
		return "updateOk";
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		String sql = "delete from t_user where t_id = ?";
		jdbcTemlate.update(sql,id);
		return "deleteOk";
	}
}
