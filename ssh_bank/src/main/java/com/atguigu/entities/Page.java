package com.atguigu.entities;

public class Page {
	private int limit; // 每页的条数
	private int offset; // 记录索引

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
