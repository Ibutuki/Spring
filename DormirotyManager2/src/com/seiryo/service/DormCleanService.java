package com.seiryo.service;

import java.util.List;


import com.seiryo.po.DormClean;
import com.seiryo.po.PageInfo;

public interface DormCleanService {
	/**
	 * 通过账号和密码查询管理员
	 */
	public DormClean findDormClean(DormClean dormClean);

	/**
	 * 进行分页查询
	 */

	//分页查询
	public PageInfo<DormClean> findPageInfo(Integer d_id, String d_dormbuilding, 
			Integer currentPage, Integer pageSize);

	public int addDormClean(DormClean dormClean);    //添加管理员信息
	public int deleteDormClean(Integer g_id);   //删除管理员信息
	public int updateDormClean(DormClean dormClean); //修改管理员信息
	public DormClean findDormCleanById(Integer g_id);
	public List<DormClean> getAll();
}
