/* * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*      FILE NAME : SignUpController.java
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
* * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.devoops.controller.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devoops.component.BaseComponent;
import com.devoops.domain.CustUser;
import com.devoops.service.custuser.CustUserService;

import lombok.extern.slf4j.Slf4j;
import utils.CryptUtils;
import utils.DateUtils;

@RestController
@Slf4j
public class SignUpController extends BaseComponent {
	
	@Autowired
	CustUserService custUserService;
	
	@PostMapping(value = "/auth/signUp")
	public CustUser postSignUp(@RequestBody CustUser custUser) {
		
		custUser.setUserPw(CryptUtils.hashSHA256(custUser.getUserPw()));
		//custUser.setEmailAuthYn("N");
		custUser.setUseYn("Y");
		custUser.setRegUserId(custUser.getUserId());
		custUser.setRegDt(DateUtils.getTimeStamp());

		custUserService.userSave(custUser);
		
		if(log.isDebugEnabled()) {
			log.debug("custUser : " + custUser);
		}
		
		return custUser;
	}
	
}
