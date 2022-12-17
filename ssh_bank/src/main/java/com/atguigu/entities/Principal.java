package com.atguigu.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Principal {

	private Integer pid;    //负责人id
	private String pname;   //负责人名称
	private String identity;   //调查身份
	private String  dname;  //部门名称
	private Integer level;
	private Customer customer;   //客户;一个负责人只能负责一个客户
	
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Principal() {
		super();
	}

	public Principal(Integer pid, String pname, String identity, String dname, Integer level) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.identity = identity;
		this.dname = dname;
		this.level = level;
	}

	@Override
	public String toString() {
		return "Principal [pid=" + pid + ", pname=" + pname + ", identity=" + identity + ", dname=" + dname + ", level="
				+ level + "]";
	}
}
