package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.StudentDao;
import com.seiryo.po.PageInfo;
import com.seiryo.po.Student;
import com.seiryo.service.StudentService;
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDao studentDao;


	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);
	}

	@Override
	public int deleteStudent(Integer a_id) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(a_id);
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}

	@Override
	public Student findStudentById(Integer a_id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(a_id);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentDao.getAll();
	}

	@Override
	public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid, String s_classname,Integer s_classid,
			Integer currentPage, Integer pageSize) {
		PageInfo<Student> pi = new PageInfo<Student>();
		pi.setPageIndex(currentPage);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = studentDao.totalCount(s_name, s_studentid, s_classid, s_classname);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示管理员信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<Student> studentList =	studentDao.getStudentList(s_name, s_studentid, s_classid, s_classname,
					(pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageIndex() * pi.getPageSize());
			pi.setList(studentList);
		}
		return pi;
	}

}
