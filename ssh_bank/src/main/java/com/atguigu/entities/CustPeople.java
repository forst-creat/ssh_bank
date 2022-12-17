package com.atguigu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustPeople {

	private Integer cpid;    //客户人员id
	private String cpname;   //客户人员姓名
	private String duty;     //客户人员职称
	private String mobile;   //客户人员联系方式
	private Integer level;
	private Customer customer; // 一个客户人员只能属于一个客户[公司];一对一关系

	
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCpid() {
		return cpid;
	}

	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}

	public String getCpname() {
		return cpname;
	}

	public void setCpname(String cpname) {
		this.cpname = cpname;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public CustPeople() {
		super();
	}

	public CustPeople(Integer cpid, String cpname, String duty, String mobile, Integer level) {
		super();
		this.cpid = cpid;
		this.cpname = cpname;
		this.duty = duty;
		this.mobile = mobile;
		this.level = level;
	}

	@Override
	public String toString() {
		return "CustPeople [cpid=" + cpid + ", cpname=" + cpname + ", duty=" + duty + ", mobile=" + mobile + ", level="
				+ level + "]";
	}


}
