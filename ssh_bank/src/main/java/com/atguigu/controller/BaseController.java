package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {


	
	@RequestMapping(value = "/bottom")
	public String bootom() {
		return "bottom";
	}
	
	@RequestMapping(value = "/query")
	public String query() {
		return "query";
	}
	
	@RequestMapping(value = "/add")
	public String add() {
		return "add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit() {
		return "edit";
	}
	
	@RequestMapping(value = "/success")
	public String success() {
		return "success";
	}
}
