package com.seiryo.service;

import java.util.List;


import com.seiryo.po.DormRepair;
import com.seiryo.po.PageInfo;

public interface DormrepairService {

	//分页查询
	public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer currentPage, Integer pageSize);

	public int addDormRepair(DormRepair dormRepair);    //添加管理员信息
	public int deleteDormRepair(Integer r_id);   //删除管理员信息
	public int updateDormRepair(DormRepair dormRepair); //修改管理员信息
	public DormRepair findDormRepairById(Integer r_id);
	public List<DormRepair> getAll();
}
