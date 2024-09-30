package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.ClassDao;
import com.seiryo.po.Class;
import com.seiryo.po.PageInfo;
import com.seiryo.service.ClassService;
@Service("classService")
@Transactional
public class ClassServiceImpl implements ClassService {
	@Autowired
	ClassDao classDao;
	@Override
	public int updateClass(Class cla) {
		
		return classDao.updateClass(cla);
	}

	@Override
	public Class findClassById(Integer c_id) {
		// TODO Auto-generated method stub
		return classDao.findClassById(c_id);
	}

	@Override
	public int addClass(Class cla) {
		// TODO Auto-generated method stub
		return classDao.addClass(cla);
	}

	@Override
	public int deleteClass(Integer c_id) {
		// TODO Auto-generated method stub
		return classDao.deleteClass(c_id);
	}

	@Override
	public PageInfo<Class> findPageInfo(Integer c_classid, String c_classname, String c_counsellor, Integer pageIndex,
			Integer pageSize) {
		PageInfo<Class> pi = new PageInfo<Class>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = classDao.totalCount(c_classid,c_classname,c_counsellor);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示管理员信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<Class> classList =	classDao.getClassList(c_classid, c_classname, c_counsellor, 
					(pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageIndex() * pi.getPageSize());
			pi.setList(classList);
		}
		return pi;
	}

	@Override
	public List<Class> getAll() {
		// TODO Auto-generated method stub
		return classDao.getAll();
	}

}
