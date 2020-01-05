package com.devoops.controller;

import com.devoops.domain.CustUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tessst {


	@RequestMapping(value = "/test")
	public String test() {

		return "asdasd";



	}
}
