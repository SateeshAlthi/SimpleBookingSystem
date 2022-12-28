package com.te.sbs.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Entity

public class SportField implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sportFieldId;
	private String sportsName;
	private String description;
	private Double priceHourly;

	@JsonFormat(pattern = "HH",shape=JsonFormat.Shape.STRING)
	private LocalTime startingHour;
	
	@JsonFormat(pattern = "HH",shape=JsonFormat.Shape.STRING)
	private LocalTime endingHour;
	
	private LocalDateTime requestOn;

}
