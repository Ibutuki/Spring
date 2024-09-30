package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.DormCleanDao;
import com.seiryo.po.DormClean;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormCleanService;
@Service("dormCleanService")
@Transactional
public class DormCleanServiceImpl implements DormCleanService{
	@Autowired
	DormCleanDao dormCleanDao;
	@Override
	public DormClean findDormClean(DormClean dormClean) {
		// TODO Auto-generated method stub
		return dormCleanDao.findDormClean(dormClean);
	}

	@Override
	public PageInfo<DormClean> findPageInfo(Integer d_id, String d_dormbuilding,
			Integer pageIndex,
			Integer pageSize) {
		PageInfo<DormClean> pi = new PageInfo<DormClean>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = dormCleanDao.totalCount(d_id, d_dormbuilding);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示管理员信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<DormClean> adminList =	dormCleanDao.getDormCleanList(d_id, d_dormbuilding, (pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageIndex() * pi.getPageSize());
			pi.setList(adminList);
		}
		return pi;
	}

	@Override
	public int addDormClean(DormClean dormClean) {
		// TODO Auto-generated method stub
		return dormCleanDao.addDormClean(dormClean);
	}

	@Override
	public int deleteDormClean(Integer g_id) {
		// TODO Auto-generated method stub
		return dormCleanDao.deleteDormClean(g_id);
	}

	@Override
	public int updateDormClean(DormClean dormClean) {
		// TODO Auto-generated method stub
		return dormCleanDao.updateDormClean(dormClean);
	}

	@Override
	public DormClean findDormCleanById(Integer g_id) {
		// TODO Auto-generated method stub
		return dormCleanDao.findDormCleanById(g_id);
	}

	@Override
	public List<DormClean> getAll() {
		// TODO Auto-generated method stub
		return dormCleanDao.getAll();
	}

}
