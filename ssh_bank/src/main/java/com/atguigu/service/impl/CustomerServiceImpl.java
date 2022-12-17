package com.atguigu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.entities.Customer;
import com.atguigu.entities.Result;
import com.alibaba.fastjson.JSONArray;
import com.atguigu.dao.CustomerDao;
import com.atguigu.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public void insertAllOrPart(Result result) {
		customerDao.insertAllOrPart(result);
	}

	@Override
	public void deleteCust(List<Integer> idList) {
		customerDao.deleteCust(idList);
	}

	@Override
	public Result editCust(Integer id) {
		return customerDao.editCust(id);
	}

	@Override
	public void updateCust(Result result) {
		customerDao.updateCust(result);

	}

	@Override
	public void deleteEmp(Map<String, Object> map) {

		String str1 = map.get("pid").toString();
		JSONArray array1 = JSONArray.parseArray(str1);
		String str2 = map.get("cpid").toString();
		JSONArray array2 = JSONArray.parseArray(str2);
		String str3 = map.get("ppid").toString();
		JSONArray array3 = JSONArray.parseArray(str3);
		customerDao.deleteEmp(array1, array2, array3);
	}

}
