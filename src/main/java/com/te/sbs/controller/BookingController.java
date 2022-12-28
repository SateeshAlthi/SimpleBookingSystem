package com.te.sbs.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.BookingSportDto;
import com.te.sbs.response.AppResponse;
import com.te.sbs.service.BookingServiceInterface;

@RestController
@RequestMapping(path="/booking")
public class BookingController {
	
	@Autowired
	private AppResponse response;
	
	@Autowired
	private BookingServiceInterface bookingService;
	
	@PostMapping("/bookingSport/{defaultUsersId}")
	public ResponseEntity<AppResponse> sportFieldCreation(@PathVariable("defaultUsersId") Short defaultUsersId,@RequestBody String sportsName,BookingSportDto bookingSportDto ){
	    BookingSportDto bookingSport = bookingService.bookingSport(defaultUsersId,sportsName,bookingSportDto);
	    if(bookingSport!=null) {
	    	response.setError(false);
			response.setMessage("Sport Booking was successfull");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(bookingSportDto));
			return new ResponseEntity<>(response, HttpStatus.OK);
	    }   else {
			response.setError(true);
			response.setMessage("Sport Booking was unsucessfull");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
