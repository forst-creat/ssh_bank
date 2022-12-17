package com.atguigu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PartPrincipal {

	private Integer ppid; // 分行人员id
	private String ppname; // 分行人员姓名
	private String organization; // 机构名称
	private String duty; // 职务
	private String ppMobile; // 联系方式
	private Integer level;
	private Customer customer; //客户

	
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getPpid() {
		return ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	public String getPpname() {
		return ppname;
	}

	public void setPpname(String ppname) {
		this.ppname = ppname;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPpMobile() {
		return ppMobile;
	}

	public void setPpMobile(String ppMobile) {
		this.ppMobile = ppMobile;
	}

	public PartPrincipal() {
		super();
	}
	
	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public PartPrincipal(Integer ppid, String ppname, String organization, String duty, String ppMobile,
			Integer level) {
		super();
		this.ppid = ppid;
		this.ppname = ppname;
		this.organization = organization;
		this.duty = duty;
		this.ppMobile = ppMobile;
		this.level = level;
	}

	@Override
	public String toString() {
		return "PartPrincipal [ppid=" + ppid + ", ppname=" + ppname + ", organization=" + organization + ", duty="
				+ duty + ", ppMobile=" + ppMobile + ", level=" + level + "]";
	}

}
