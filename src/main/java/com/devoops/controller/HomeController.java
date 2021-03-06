/* * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*      FILE NAME : HomeController.java
* REPORTING DATE : 2019.11.04
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
* * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.devoops.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String index() {
		
		return "index";
	}

	//추후수정필요
	@RequestMapping(value = "/common/{common}")
	public String common(@PathVariable Map<String,Object> pathVal) {

		return "common/" + pathVal.get("common");
	}
	
	@RequestMapping(value = "/test")
	public String test() {
		
		return "index";
	}
	
	@RequestMapping(value = "/auth/signUp")
	public String getSignUp() {
		
		return "auth/signUp";
	}
}
