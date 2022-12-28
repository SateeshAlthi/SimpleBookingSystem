package com.te.sbs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	
	private String roleName;
	
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	private List<AppUser> appUsers = Lists.newArrayList();
}
