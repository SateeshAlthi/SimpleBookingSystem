package com.te.sbs.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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

public class Booking implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@ManyToOne (targetEntity = BookStatus.class, cascade = CascadeType.ALL)
	private BookStatus bookStatus;
	
	@ManyToOne(targetEntity = SportField.class, cascade = CascadeType.ALL)
	private SportField sportfield;
	
	@ManyToMany(targetEntity = DefaultUsers.class, cascade = CascadeType.ALL)
	private List<DefaultUsers> defaultUsers=new ArrayList<DefaultUsers>();
	
}
