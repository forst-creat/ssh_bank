package com.atguigu.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.entities.Customer;

public interface PaginationDao {
	
	List<Customer> getAllListPage(Customer customer);
	
	Integer getTotal();

}
