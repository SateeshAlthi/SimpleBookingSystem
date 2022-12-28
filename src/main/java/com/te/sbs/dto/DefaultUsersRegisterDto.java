package com.te.sbs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DefaultUsersRegisterDto {
	
//	private Short defaultUsersId;
	private String email;
	private String password;
	private String salt;
	private Integer groupId;
	private String ipAddress;
	private Boolean active;
	private String activationCode;
	private Integer createdOn;
	private Integer lastLogin;
	private String userName;
	private String forgottenPasswordCode;
	private String rememberCode;
	
}
