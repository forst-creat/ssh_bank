package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.atguigu.service.ExcelService;

@Controller
public class ExcelController {
	
	@Autowired
	private ExcelService excelService;
	
	@RequestMapping("/excel")
	public ResponseEntity<byte[]> exportExcel(Integer id) {
		return excelService.exportExcel(id);
	}

}
