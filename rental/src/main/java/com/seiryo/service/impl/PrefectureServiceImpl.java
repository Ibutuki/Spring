package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.PrefectureMapper;
import com.seiryo.pojo.Prefecture;
import com.seiryo.service.PrefectureService;
/**
 * サービス実装クラス：都道府県
 */
@Service
@Transactional
public class PrefectureServiceImpl implements PrefectureService{
	@Autowired
	PrefectureMapper prefectureMapper;
	
	@Override
	public List<Prefecture> getAllPrefectures() {
		return prefectureMapper.getAllPrefectures();
	}

}
