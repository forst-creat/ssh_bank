package com.atguigu.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.atguigu.entities.CustPeople;
import com.atguigu.entities.Customer;
import com.atguigu.entities.PartPrincipal;
import com.atguigu.entities.Principal;
import com.atguigu.entities.Result;
import com.atguigu.service.CustomerService;
import com.atguigu.service.ExcelService;
import com.atguigu.service.impl.CustomerServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired 
	private ExcelService excelService;

	//插入
	@PostMapping(value = "/insert")
	@ResponseBody
	public String insertAllOrPart(@RequestBody Result result) {
		/* System.out.println(result); */
	
		customerService.insertAllOrPart(result);
		return "success";	
	}
	
	
	
	//删除
	@PostMapping(value = "/delete")
	@ResponseBody
	public String deleteCust(@RequestBody List<Integer> idList) {	
		
		System.out.println(idList); 	 
		customerService.deleteCust(idList);
		return "success";
	}
	
	//编辑
	@GetMapping("/squery")
	@ResponseBody
	public Result editCust(@RequestParam("id") Integer id) {
	System.out.println(id);
		Result result = customerService.editCust(id);		
		return result;
	}
	
	
	  @PostMapping("/update")
	  @ResponseBody 
	  public String updateCust(@RequestBody Result result) { 
		  System.out.println(result);
			
			  customerService.updateCust(result); return "success";
			 
			/* return "success"; */
	  
	  }
	  
	  
	  @PostMapping("/deleteEmp")
	  @ResponseBody
	  public String deleteEmp(@RequestBody Map<String,Object> map) {

		  customerService.deleteEmp(map);
		  return "success";  
	  }
	  
	 
	  @RequestMapping(value = "/export",method = {RequestMethod.GET,RequestMethod.POST})
	  @ResponseBody
	  public void exportCust(HttpServletRequest request,HttpServletResponse response) {
		  
			/* String mether =request.getMethod(); */
			List<Customer> list = excelService.exportCust();
			HSSFWorkbook wb = new HSSFWorkbook();// 第一步:创建工作薄
			HSSFSheet sheet = wb.createSheet("客户记录表");// 第二步:创建工作表
			sheet.setDefaultColumnWidth(15);// 设置表宽
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中 
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
			org.apache.poi.hssf.usermodel.HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 12);
			HSSFCellStyle headerStyle = wb.createCellStyle();
			org.apache.poi.hssf.usermodel.HSSFFont headerFont = wb.createFont();
			headerFont.setFontHeightInPoints((short) 14);
			headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			headerStyle.setFont(headerFont);
			CellRangeAddress cra0 = new CellRangeAddress(0, 1, 0, 9);  //合并单元格
			sheet.addMergedRegion(cra0);
			sheet.setDefaultColumnWidth((short) 15);
			Row row = sheet.createRow(0);  //第三步:创建行
			Cell cell1 = row.createCell(0);  //第四步:创建单元格(行、列)
			
	        cell1.setCellValue("客户记录表");
	        cell1.setCellStyle(headerStyle);
	        
	        //设置字体样式
	        org.apache.poi.hssf.usermodel.HSSFFont titleFont = wb.createFont();
	        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        style.setFont(titleFont);
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

	        Row row1 = sheet.createRow(2);
	        Cell cell = row1.createCell(0);
	        cell.setCellValue("客户名称");
	        cell.setCellStyle(style);
	        cell = row1.createCell(1);
	        cell.setCellValue("起始时间");
	        cell.setCellStyle(style);
	        cell = row1.createCell(2);
	        cell.setCellValue("结束时间");
	        cell.setCellStyle(style);
	        cell = row1.createCell(3);
	        cell.setCellValue("业务场景");
	        cell.setCellStyle(style);
	        cell = row1.createCell(4);
	        cell.setCellValue("工作类型");
	        cell.setCellStyle(style);
	        cell = row1.createCell(5);
	        cell.setCellValue("阶段");
	        cell.setCellStyle(style);
	        cell = row1.createCell(6);
	        cell.setCellValue("目标(起因)");
	        cell.setCellStyle(style);
	        cell = row1.createCell(7);
	        cell.setCellValue("内容(经过)");
	        cell.setCellStyle(style);
	        cell = row1.createCell(8);
	        cell.setCellValue("效果(结果)");
	        cell.setCellStyle(style);
	        
	        //时间转字符串的格式
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        for (int i = 0, imax = list.size(); i < imax; i++) {
	            row1 = sheet.createRow(i + 3);
	            if (list.get(i).getFullName() == null||"".equals(list.get(i).getFullName())) {
	                row1.createCell(0).setCellValue("-");
	            } else {
	                row1.createCell(0).setCellValue(list.get(i).getFullName());
	            }
	            if (list.get(i).getStartTime() == null ||"".equals(list.get(i).getStartTime())) {
	                row1.createCell(1).setCellValue("-");
	            } else {
	                row1.createCell(1).setCellValue(sdf.format(list.get(i).getStartTime()));
	            }
	            if (list.get(i).getEndTime() == null ||"".equals(list.get(i).getEndTime())) {
	                row1.createCell(2).setCellValue("-");
	            } else {
	                row1.createCell(2).setCellValue(sdf.format(list.get(i).getEndTime()));
	            }
	            if (list.get(i).getService() == null||"".equals(list.get(i).getService())) {
	                row1.createCell(3).setCellValue("-");
	            } else {
	                row1.createCell(3).setCellValue(list.get(i).getService());
	            }
	            if (list.get(i).getJobKind() == null||"".equals(list.get(i).getJobKind())) {
	                row1.createCell(4).setCellValue("-");
	            } else {
	                row1.createCell(4).setCellValue(list.get(i).getJobKind());
	            }
	            if (list.get(i).getPhase() == null||"".equals(list.get(i).getPhase())) {
	                row1.createCell(5).setCellValue("-");
	            } else {
	                row1.createCell(5).setCellValue(list.get(i).getPhase());
	            }
	            if (list.get(i).getTarget() == null||"".equals(list.get(i).getTarget())) {
	                row1.createCell(6).setCellValue("-");
	            } else {
	                row1.createCell(6).setCellValue(list.get(i).getTarget());
	            }
	            if (list.get(i).getContent() == null||"".equals(list.get(i).getContent())) {
	                row1.createCell(7).setCellValue("-");
	            } else {
	                row1.createCell(7).setCellValue(list.get(i).getContent());
	            }
	            if (list.get(i).getEffect() == null||"".equals(list.get(i).getEffect())) {
	                row1.createCell(8).setCellValue("-");
	            } else {
	                row1.createCell(8).setCellValue(list.get(i).getEffect());
	            }
	        }

			  response.reset();
			  //文件下载,限制类型
			  response.setContentType("application/msexcel;charset=UTF-8");
	
	        try {
				SimpleDateFormat newsdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = newsdf.format(new Date());
				//设置下载后的文件名
				response.addHeader("Content-Disposition", "attachment;filename=\""
						+ new String(("客户记录表" + date + ".xls").getBytes("GBK"), "ISO8859_1") + "\""); 
	            OutputStream out = response.getOutputStream();
	            wb.write(out);
	            out.flush();
	            out.close();
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "导出失败!");
	            e.printStackTrace();
	        }
	  }

}
