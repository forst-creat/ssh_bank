package com.atguigu.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.atguigu.controller.ExcelFormatController;
import com.atguigu.dao.CustomerDao;
import com.atguigu.entities.Customer;
import com.atguigu.entities.Result;
import com.atguigu.service.ExcelService;
import com.atguigu.utils.ExcelFormatUtils;




@Service
public class ExcelServiceImpl implements ExcelService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> exportCust() {
		return customerDao.exportCust();	
	}
	


}
