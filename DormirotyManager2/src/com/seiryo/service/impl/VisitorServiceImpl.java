package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.VisitorDao;
import com.seiryo.po.PageInfo;
import com.seiryo.po.Visitor;
import com.seiryo.service.VisitorService;
@Service("visitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService{
	@Autowired
	VisitorDao visitorDao;

	@Override
	public PageInfo<Visitor> findPageInfo(String v_name, String v_phone, Integer currentPage, Integer pageSize) {
		PageInfo<Visitor> pi = new PageInfo<Visitor>();
		pi.setPageIndex(currentPage);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = visitorDao.totalCount(v_name, v_phone);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示管理员信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<Visitor> adminList = visitorDao.getVisitorList(v_name, v_phone, 
					(pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageIndex() * pi.getPageSize());
			pi.setList(adminList);
		}
		return pi;
	}

	@Override
	public int addVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitorDao.addVisitor(visitor);
	}

	@Override
	public List<Visitor> getAll() {
		// TODO Auto-generated method stub
		return visitorDao.getAll();
	}

}
