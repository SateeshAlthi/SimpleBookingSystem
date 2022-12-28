package com.te.sbs.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingSportDto {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

//	PARAMETERS from SportField Class not required here as I am giving it as an argument in the method 
//	private String sportsName;

	@JsonFormat(pattern = "HH", shape = JsonFormat.Shape.STRING)
	private LocalTime startingHour;

	@JsonFormat(pattern = "HH", shape = JsonFormat.Shape.STRING)
	private LocalTime endingHour;

//  PARAMETERS from DefaultUsers CLASS not required here as I am giving it from the Path Variable
//	private Short defaultUsersId;

}
