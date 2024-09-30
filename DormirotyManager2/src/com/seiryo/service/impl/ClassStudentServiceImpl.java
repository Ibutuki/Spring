package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.ClassStudentDao;
import com.seiryo.po.Class;
import com.seiryo.service.ClassStudentService;
@Service("classStudent")
@Transactional
public class ClassStudentServiceImpl implements ClassStudentService{
	@Autowired
	ClassStudentDao classStudentDao;
	@Override
	public List<Class> findClassStudent(Integer c_classid, String c_classname) {
		// TODO Auto-generated method stub
		return classStudentDao.findClassStudent(c_classid, c_classname);
	}

}
