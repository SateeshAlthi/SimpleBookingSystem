package com.te.sbs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class DefaultUsers implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short defaultUsersId;
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
