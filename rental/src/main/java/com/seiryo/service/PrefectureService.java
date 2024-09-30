package com.seiryo.service;

import java.util.List;

import com.seiryo.pojo.Prefecture;

/**
 * サービスインタフェース：都道府県
 */
public interface PrefectureService {
	// すべての都道府県を検索する
	List<Prefecture> getAllPrefectures();
}
