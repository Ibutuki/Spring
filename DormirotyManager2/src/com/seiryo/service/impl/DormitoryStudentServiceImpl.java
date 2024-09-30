package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.DormitoryStudentDao;
import com.seiryo.po.Dormitory;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormitoryStudentService;
@Service("dormitoryStudentService")
@Transactional
public class DormitoryStudentServiceImpl implements DormitoryStudentService{
	@Autowired
	DormitoryStudentDao dormitoryStudentDao;
//	@Override
//	public PageInfo<Dormitory> findPageInfo(Integer s_dormitoryid, Integer pageIndex, Integer pageSize) {
//		PageInfo<Dormitory> pi = new PageInfo<Dormitory>();
//		pi.setPageIndex(pageIndex);
//		pi.setPageSize(pageSize);
//		//获取总条数
//		Integer totalCount = dormitoryStudentDao.totalCount(s_dormitoryid);
//		if (totalCount>0){
//			pi.setTotalCount(totalCount);
//			//每一页显示管理员信息数
//			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
//			List<Dormitory> adminList =	dormitoryStudentDao.findDormitoryStudent(s_dormitoryid,
//					 (pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageIndex() * pi.getPageSize());
//			pi.setList(adminList);
//		}
//		return pi;
//	}

	@Override
	public List<Dormitory> findDormitoryStudent(Integer s_dormitoryid) {
		// TODO Auto-generated method stub
		return dormitoryStudentDao.findDormitoryStudent(s_dormitoryid);
	}
	
}
