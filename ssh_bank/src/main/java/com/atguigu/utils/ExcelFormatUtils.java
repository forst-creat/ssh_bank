package com.atguigu.utils;

import java.awt.Color;


import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;




public class ExcelFormatUtils {
	
	public static CellStyle headSytle(Workbook wb){
		XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);   //设置填充方案
		style.setFillForegroundColor(new XSSFColor(new Color(255,255,255)));   //设置自定义填充颜色
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		Font font = wb.createFont();
		font.setBoldweight((short) 10);
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		style.setWrapText(true);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		return style;
	}

	public static CellStyle contentStyle(Workbook wb){
		CellStyle style = wb.createCellStyle();// cell样式
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setWrapText(true);// 设置自动换行
		style.setAlignment(XSSFCellStyle.ALIGN_LEFT);// 设置单元格字体显示居中（左右方向）
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 设置单元格字体显示居中(上下方向)
		return style;
	}


	//设置表头
	public static void initTitleEX(SXSSFSheet sheet, CellStyle header,String title[]) {
		
		SXSSFRow row0 = sheet.createRow(0);
		row0.setHeight((short) 800);	
		for(int j = 0;j<title.length; j++) {
			SXSSFCell cell = row0.createCell(j);
			//设置每一列的字段名
			cell.setCellValue(title[j]);
			cell.setCellStyle(header);
		}
	}
}
