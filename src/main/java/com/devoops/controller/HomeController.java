/* * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*      FILE NAME : HomeController.java
* REPORTING DATE : 2019.11.04
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
* * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.devoops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String index() {
		
		return "index";
	}

	//추후수정필요
	@RequestMapping(value = "/common/common")
	public String common() {

		return "common/common";
	}
}
