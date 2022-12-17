package com.atguigu.dao;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.atguigu.entities.Customer;
import com.atguigu.entities.Result;


public interface CustomerDao {
	
	void insertAllOrPart(Result result);
	
	void deleteCust(List<Integer> idList);
		
	void updateCust(Result result);

	Result editCust(Integer id);
	
	void deleteEmp(JSONArray array1,JSONArray array2,JSONArray array3);
	
	List<Customer> exportCust();
}
