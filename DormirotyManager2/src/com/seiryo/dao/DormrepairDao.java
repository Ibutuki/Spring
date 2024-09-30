package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.po.DormRepair;

/*
 * 保修
 */
public interface DormrepairDao {

	/**
	 * 进行分页查询
	 */

	//获取总条数
	public Integer totalCount(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding);
	//获取用户列表
	public List<DormRepair> getDormRepairList(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	public int addDormRepair(DormRepair dormRepair);    //添加管理员信息
	public int deleteDormRepair(Integer r_id);   //删除管理员信息
	public int updateDormRepair(DormRepair dormRepair); //修改管理员信息
	public DormRepair findDormRepairById(Integer r_id);
	public List<DormRepair> getAll();
}
