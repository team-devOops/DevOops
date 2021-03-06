package com.devoops.domain;

import javax.persistence.*;

import com.devoops.mgr.CustInfo;

import lombok.*;

@Getter @Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "T_CUST_USER")
public class CustUser extends BaseVO implements CustInfo {
	
	@Id
	private String userId;
	private String userPw;
	private String name;
	private String email;
	private String emailAuthYn;
	private String imgUrl;
	private String useYn;

}