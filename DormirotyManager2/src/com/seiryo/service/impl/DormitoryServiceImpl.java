package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.DormitoryDao;
import com.seiryo.po.Dormitory;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormitoryService;
@Service("dormitoryService")
@Transactional
public class DormitoryServiceImpl implements DormitoryService{
	@Autowired
	DormitoryDao dormitoryDao;

	@Override
	public int addDormitory(Dormitory dormitory) {
		// TODO Auto-generated method stub
		return dormitoryDao.addDormitory(dormitory);
	}

	@Override
	public int deleteDormitory(Integer g_id) {
		// TODO Auto-generated method stub
		return dormitoryDao.deleteDormitory(g_id);
	}

	@Override
	public int updateDormitory(Dormitory dormitory) {
		// TODO Auto-generated method stub
		return dormitoryDao.updateDormitory(dormitory);
	}

	@Override
	public Dormitory findDormitoryById(Integer g_id) {
		// TODO Auto-generated method stub
		return dormitoryDao.findDormitoryById(g_id);
	}

	@Override
	public List<Dormitory> getAll() {
		// TODO Auto-generated method stub
		return dormitoryDao.getAll();
	}

	@Override
	public PageInfo<Dormitory> findPageInfo(Integer s_dormitoryid, String d_dormbuilding, String a_name,
			Integer pageIndex, Integer pageSize) {
		PageInfo<Dormitory> pi = new PageInfo<Dormitory>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = dormitoryDao.totalCount(s_dormitoryid, d_dormbuilding, a_name);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示管理员信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<Dormitory> adminList =	dormitoryDao.getDormitoryList(s_dormitoryid, d_dormbuilding, a_name, 
					(pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageIndex() * pi.getPageSize());
			pi.setList(adminList);
		}
		return pi;
	}

}
