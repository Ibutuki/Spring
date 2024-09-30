package com.seiryo.service;

import java.util.List;


import com.seiryo.po.PageInfo;
import com.seiryo.po.Visitor;

public interface VisitorService {

	//分页查询
	public PageInfo<Visitor> findPageInfo( String v_name, String v_phone,
			Integer currentPage, Integer pageSize);

	public int addVisitor(Visitor visitor);    //添加管理员信息


	public List<Visitor> getAll();
}
