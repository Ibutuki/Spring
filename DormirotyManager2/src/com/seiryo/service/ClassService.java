package com.seiryo.service;

import java.util.List;


import com.seiryo.po.Class;
import com.seiryo.po.PageInfo;

public interface ClassService {
	List<Class> getAll();
	int updateClass(Class cla);
	//id查
	Class findClassById(Integer c_id);
	int addClass(Class cla);
	int deleteClass(Integer c_id);
	public PageInfo<Class> findPageInfo(Integer c_classid, String c_classname, String c_counsellor, Integer pageIndex, Integer pageSize);

	//exportclasslist导出
}
