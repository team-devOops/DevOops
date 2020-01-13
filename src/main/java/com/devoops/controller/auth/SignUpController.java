/* * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*      FILE NAME : SignUpController.java
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
* * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.devoops.controller.auth;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devoops.domain.CustUser;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SignUpController {
	

	
	@PostMapping(value = "/auth/signUp")
	public CustUser postSignUp(@RequestBody CustUser custUser) {
		
		if(log.isDebugEnabled()) {
			log.debug("custUser : " + custUser);
		}
		
		return custUser;
	}
}
