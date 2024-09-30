package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.StudentCleanDao;
import com.seiryo.po.PageInfo;
import com.seiryo.po.StudentClean;
import com.seiryo.service.StudentCleanService;
@Service("studentCleanService")
@Transactional
public class StudentCleanServiceImpl implements StudentCleanService{
	@Autowired
	StudentCleanDao studentCleanDao;

	@Override
	public PageInfo<StudentClean> findPageInfo(String s_studentid, String s_name, Integer s_dormitoryid,
			Integer currentPage, Integer pageSize) {
		PageInfo<StudentClean> pi = new PageInfo<StudentClean>();
		pi.setPageIndex(currentPage);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = studentCleanDao.totalCount(s_studentid, s_name, s_dormitoryid);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示管理员信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<StudentClean> adminList =	studentCleanDao.getStudentCleanList(s_studentid, s_name, s_dormitoryid,
					(pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageIndex() * pi.getPageSize());
			pi.setList(adminList);
		}
		return pi;
		
	}

	@Override
	public int addStudentClean(StudentClean studentClean) {
		// TODO Auto-generated method stub
		return studentCleanDao.addStudentClean(studentClean);
	}

	@Override
	public int deleteStudentClean(Integer a_id) {
		// TODO Auto-generated method stub
		return studentCleanDao.deleteStudentClean(a_id);
	}

	@Override
	public int updateStudentClean(StudentClean studentClean) {
		// TODO Auto-generated method stub
		return studentCleanDao.updateStudentClean(studentClean);
	}

	@Override
	public StudentClean findStudentCleanById(Integer a_id) {
		// TODO Auto-generated method stub
		return studentCleanDao.findStudentCleanById(a_id);
	}

	@Override
	public List<StudentClean> getAll() {
		// TODO Auto-generated method stub
		return studentCleanDao.getAll();
	}

}
