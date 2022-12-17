package com.atguigu.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.atguigu.entities.Customer;

public interface ExcelService {
	
	@Transactional
	List<Customer> exportCust();
}
