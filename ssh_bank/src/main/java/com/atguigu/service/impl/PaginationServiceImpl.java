package com.atguigu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.dao.PaginationDao;
import com.atguigu.entities.Customer;
import com.atguigu.service.PaginationService;

@Service
public class PaginationServiceImpl implements PaginationService{

	@Autowired
	private PaginationDao paginationDao;
	
	@Override
	public List<Customer> getAllListPage(Customer customer) {
		
		return paginationDao.getAllListPage(customer);
	}

	@Override
	public Integer getTotal() {
		
		return paginationDao.getTotal();
	}

}
