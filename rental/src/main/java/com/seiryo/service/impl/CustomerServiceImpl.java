package com.seiryo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seiryo.dao.CustomerMapper;
import com.seiryo.pojo.Customer;
import com.seiryo.service.CustomerService;

/**
 * サービス実装クラス：会員
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public Customer getCustomerById(String memId) {
		return customerMapper.getCustomerById(memId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerMapper.getAllCustomers();
	}

	@Override
	public List<Customer> getCustomerList(Customer customer) {
		return customerMapper.getCustomerList(customer);
	}

	@Override
	public int insertCustomer(Customer customer) {
		return customerMapper.insertCustomer(customer);
	}

	@Override
	public int updateCustomer(Customer customer) {
		return customerMapper.updateCustomer(customer);
	}

	@Override
	public int cancelCustomer(String memId) {
		return customerMapper.cancelCustomer(memId);
	}

}
