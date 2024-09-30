package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.seiryo.pojo.Category;

/**
 * DAOクラス：DBのカテゴリー（Category）テーブルを扱う
 */
@Repository
public interface CategoryMapper {
	
	// IDによる検索する
	Category getCategoryById(@Param("categoryCd") String categoryCd);
	
	// すべてのカテゴリーを検索する
	List<Category> getCategoryList();
	    
//	// カテゴリーを登録する
//	int insertCategory(Category category);
//	    
//	// カテゴリー情報を更新する
//	int updateCategory(Category category);
//	
//	// カテゴリーを削除する
//	int delCategory(@Param("categoryCd") String categoryCd);
}
