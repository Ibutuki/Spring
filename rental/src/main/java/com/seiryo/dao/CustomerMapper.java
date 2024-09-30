package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.seiryo.pojo.Customer;

/**
 * DAOクラス：DBの会員（Customer）テーブルを扱う
 */
@Repository
public interface CustomerMapper {
	
	// IDによる検索する
	Customer getCustomerById(@Param("memId")String memId);
	
	// すべての会員情報を検索する
	List<Customer> getAllCustomers();
	
	// 入力された条件で会員情報を検索する
	List<Customer> getCustomerList(Customer customer);
	    
	// 会員情報を登録する
	int insertCustomer(Customer customer);
	    
	// 会員情報を更新する
	int updateCustomer(Customer customer);
	
	// 退会処理
	int cancelCustomer(@Param("memId")String memId);
}
