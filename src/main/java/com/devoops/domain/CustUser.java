package com.devoops.domain;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "T_CUST_USER")
public class CustUser extends BaseVO {
	
	@Id
	private String userId;
	private String userPw;
	private String name;
	private String email;
	private String emailAuthYn;
	private String imgUrl;
	private String useYn;
}