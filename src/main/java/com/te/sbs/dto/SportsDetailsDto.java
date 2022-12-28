package com.te.sbs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SportsDetailsDto {
	
	private String sportsName;
	private String description;
	private Double priceHourly;

}
