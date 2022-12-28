package com.te.sbs.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@Entity
public class DateReserved implements Serializable{
	
	@Id
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate bookedDate;

	private boolean status;
	
}
