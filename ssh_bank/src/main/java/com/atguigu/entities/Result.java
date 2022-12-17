package com.atguigu.entities;

import java.util.List;
import java.util.Set;
import com.atguigu.entities.CustPeople;
import com.atguigu.entities.Customer;
import com.atguigu.entities.PartPrincipal;
import com.atguigu.entities.Principal;

public class Result {

	private Customer customer;
	private List<Principal> principal;
	private List<CustPeople> custpeople;
	private List<PartPrincipal> partprincipal;


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Principal> getPrincipal() {
		return principal;
	}

	public void setPrincipal(List<Principal> principal) {
		this.principal = principal;
	}

	public List<CustPeople> getCustpeople() {
		return custpeople;
	}

	public void setCustpeople(List<CustPeople> custpeople) {
		this.custpeople = custpeople;
	}

	public List<PartPrincipal> getPartprincipal() {
		return partprincipal;
	}

	public void setPartprincipal(List<PartPrincipal> partprincipal) {
		this.partprincipal = partprincipal;
	}

	@Override
	public String toString() {
		return "Result [customer=" + customer + ", principal=" + principal + ", custpeople=" + custpeople
				+ ", partprincipal=" + partprincipal + "]";
	}


}
