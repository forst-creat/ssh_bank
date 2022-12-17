package com.atguigu.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.atguigu.entities.Customer;
import com.atguigu.entities.Result;


public interface CustomerService {

	@Transactional
	void insertAllOrPart(Result result);
	
	
	@Transactional
	void deleteCust(List<Integer> idList);
	
	@Transactional
	Result editCust(Integer id);
	
	@Transactional
	void deleteEmp(Map<String, Object> map);

	@Transactional
	void updateCust(Result result);
}
