package com.seiryo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.pojo.Category;

/**
 * サービスインタフェース：カテゴリー
 */
public interface CategoryService {
	// IDによる検索する
	Category getCategoryById(@Param("categoryCd") String categoryCd);
	
	// すべてのカテゴリーを検索する
	List<Category> getCategoryList();
}
