package com.te.sbs.entity;

import javax.persistence.Entity;
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
public class SportsDetails {
	
	@Id
	private String sportsName;
	private String description;
	private Double priceHourly;
	
}
