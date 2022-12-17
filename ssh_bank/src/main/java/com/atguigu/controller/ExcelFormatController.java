package com.atguigu.controller;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

public class ExcelFormatController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ResponseEntity<byte[]> buildResponseEntity(InputStream is, String name) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>开始下载文件>>>>>>>>>>");
		if (this.logger.isDebugEnabled())
			this.logger.debug("download: " + name);
		HttpHeaders header = new HttpHeaders();
		String fileSuffix = name.substring(name.lastIndexOf('.') + 1);
		fileSuffix = fileSuffix.toLowerCase();
		
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		arguments.put("xls", "application/vnd.ms-excel");
		
		String contentType = arguments.get(fileSuffix);
		header.add("Content-Type", (StringUtils.hasText(contentType) ? contentType : "application/x-download"));
		if(is!=null && is.available()!=0){
			header.add("Content-Length", String.valueOf(is.available()));
			header.add("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(name, "UTF-8"));
			byte[] bs = IOUtils.toByteArray(is);
			logger.info(">>>>>>>>>>>>>>>>>>>>结束下载文件-有记录>>>>>>>>>>");
			logger.info(">>>>>>>>>>结束导出excel>>>>>>>>>>");
			return new ResponseEntity<>(bs, header, HttpStatus.OK);
		}else{
			String string="数据为空";
			header.add("Content-Length", "0");
			header.add("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(name, "UTF-8"));
			logger.info(">>>>>>>>>>>>>>>>>>>>结束下载文件-无记录>>>>>>>>>>");
			logger.info(">>>>>>>>>>结束导出excel>>>>>>>>>>");
			return new ResponseEntity<>(string.getBytes(), header, HttpStatus.OK);
		}
	}
}
