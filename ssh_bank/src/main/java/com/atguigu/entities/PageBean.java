package com.atguigu.entities;

import java.util.List;

public class PageBean<T> {

	
	private List<T> rows; // 每页的数据
	private long total; // 总条数

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public PageBean() {
		super();
	}

	public PageBean(List<T> rows, long total) {
		super();
		this.rows = rows;
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageBean [rows=" + rows + ", total=" + total + "]";
	}
	

}
