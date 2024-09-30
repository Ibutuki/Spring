package com.seiryo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seiryo.pojo.Prefecture;
/**
 * DAOクラス：都道府県（Prefecture）テーブルを扱う
 */
@Repository
public interface PrefectureMapper {
	
	// すべての都道府県を検索する
	List<Prefecture> getAllPrefectures();
	
}
