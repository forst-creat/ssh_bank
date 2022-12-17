package com.atguigu.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.atguigu.entities.Customer;

public interface PaginationService {
	
	@Transactional
	List<Customer> getAllListPage(Customer customer);
	
	@Transactional
	Integer getTotal();
		
}
