package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.DormrepairDao;
import com.seiryo.po.DormRepair;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormrepairService;
@Service("dormrepairService")
@Transactional
public class DormrepairServiceImpl implements DormrepairService{
	@Autowired
	DormrepairDao dormrepairDao;


	@Override
	public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer currentPage,
			Integer pageSize) {
		PageInfo<DormRepair> pi = new PageInfo<DormRepair>();
		pi.setPageIndex(currentPage);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = dormrepairDao.totalCount(d_id, d_dormbuilding);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示管理员信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<DormRepair> adminList = dormrepairDao.getDormRepairList(d_id, d_dormbuilding, 
					(pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageIndex() * pi.getPageSize());
			pi.setList(adminList);
		}
		return pi;
	}

	@Override
	public int addDormRepair(DormRepair dormRepair) {
		// TODO Auto-generated method stub
		return dormrepairDao.addDormRepair(dormRepair);
	}

	@Override
	public int deleteDormRepair(Integer r_id) {
		// TODO Auto-generated method stub
		return dormrepairDao.deleteDormRepair(r_id);
	}

	@Override
	public int updateDormRepair(DormRepair dormRepair) {
		// TODO Auto-generated method stub
		return dormrepairDao.updateDormRepair(dormRepair);
	}

	@Override
	public DormRepair findDormRepairById(Integer r_id) {
		// TODO Auto-generated method stub
		return dormrepairDao.findDormRepairById(r_id);
	}

	@Override
	public List<DormRepair> getAll() {
		// TODO Auto-generated method stub
		return dormrepairDao.getAll();
	}

}
