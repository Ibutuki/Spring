package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.po.DormClean;

/*宿舍卫生
 */
public interface DormCleanDao {
	/**
	 * 通过账号和密码查询管理员
	 */
	public DormClean findDormClean(DormClean dormClean);

	/**
	 * 进行分页查询
	 */

	//获取总条数
	public Integer totalCount(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding);
	//获取用户列表
	public List<DormClean> getDormCleanList(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding,
			@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	public int addDormClean(DormClean dormClean);    //添加管理员信息
	public int deleteDormClean(Integer g_id);   //删除管理员信息
	public int updateDormClean(DormClean dormClean); //修改管理员信息
	public DormClean findDormCleanById(Integer g_id);
	public List<DormClean> getAll();
}
