package com.devoops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("@@@@@@@INDEX(");
		
		return "index";
	}
	
	@RequestMapping(value = "/zz")
	public String zz() {
		System.out.println("@@@@@@@zz(");
		return "index";
	}
}
