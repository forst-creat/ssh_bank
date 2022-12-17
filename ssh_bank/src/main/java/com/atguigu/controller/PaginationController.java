package com.atguigu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.entities.Customer;
import com.atguigu.entities.Page;
import com.atguigu.entities.PageBean;
import com.atguigu.service.PaginationService;

@Controller
public class PaginationController {

	@Autowired
	private PaginationService paginationService;
	
	@RequestMapping("/findAllCustomer")
	@ResponseBody
	public PageBean findAllCustomer(Customer customer) {
		/* System.out.println(customer.getOffset() + "::::" + customer.getLimit()); */
		System.out.println("Service = " + customer.getService());
		System.out.println("Phase = " + customer.getPhase());
		System.out.println("JobKind = " + customer.getJobKind());
		PageBean<Customer> pageBean = new PageBean<Customer>();
		List<Customer> allListCustomer = paginationService.getAllListPage(customer);
		/* System.out.println(allListCustomer); */
		Integer total = paginationService.getTotal();
		/* System.out.println(total); */
		pageBean.setTotal(total);
		pageBean.setRows(allListCustomer);
		/* System.out.println(pageBean); */
		return pageBean;
	}
}
