package com.te.sbs.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.SportsDetailsDto;
import com.te.sbs.dto.SportsDetailsFetchDto;
import com.te.sbs.response.AppResponse;
import com.te.sbs.service.SportsDetailsServiceInterface;

@RestController
@RequestMapping(path="/sportdetails")
public class SportsDetailsController {

	@Autowired
	private AppResponse response;

	@Autowired
	private SportsDetailsServiceInterface sportsDetailsService;

	@PostMapping("/sportsDetailsCreation")
	public ResponseEntity<AppResponse> sportsDetailsCreation(@RequestBody SportsDetailsDto sportsDetailsDto) {
		SportsDetailsDto sportsDetailsCreation = sportsDetailsService.sportsDetailsCreation(sportsDetailsDto);
		if (sportsDetailsCreation != null) {
			response.setError(false);
			response.setMessage("sportsDetails Created Successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(sportsDetailsCreation));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("sportsDetails Creation was unsuccessful.");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/sportsDetailsDeletion")
	public ResponseEntity<AppResponse> sportsDetailsDeletion(@RequestBody SportsDetailsFetchDto sportsDetailsFetchDto) {
		SportsDetailsFetchDto sportsDetailsDeletion = sportsDetailsService.sportsDetailsDeletion(sportsDetailsFetchDto);
		if (sportsDetailsDeletion != null) {
			response.setError(false);
			response.setMessage("sportsDetails Deleted Successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(sportsDetailsDeletion));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("sportsDetails Deletion was unsuccessful.");
			response.setStatus(205);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/sportsDetailsUpdation")
	public ResponseEntity<AppResponse> sportsDetailsUpdation(@RequestBody SportsDetailsDto sportsDetailsDto) {
		SportsDetailsDto sportsDetailsUpdation = sportsDetailsService.sportsDetailsUpdation(sportsDetailsDto);
		if (sportsDetailsUpdation != null) {
			response.setError(false);
			response.setMessage("sportsDetails Updated Successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(sportsDetailsUpdation));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("sportsDetails Updation was unsuccessful");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/sportsDetailsgetAll")
	public ResponseEntity<AppResponse> sportsDetailsgetAll() {
		List<SportsDetailsDto> sportsDetailsgetAll = sportsDetailsService.sportsDetailsgetAll();
		if (sportsDetailsgetAll != null) {
			response.setError(false);
			response.setMessage("All sportsDetails data fetched Successfully");
			response.setStatus(200);
			response.setData(Arrays.asList(sportsDetailsgetAll));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("All sportsDetails data fetching was unsuccessful.");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/sportsDetailsgetByName/{sportsName}")
	public ResponseEntity<AppResponse> sportsDetailsgetByName(@PathVariable String sportsName) {
		 SportsDetailsDto sportsDetailsGetByName = sportsDetailsService.sportsDetailsGetByName(sportsName);
		if (sportsDetailsGetByName != null) {
			response.setError(false);
			response.setMessage("sportsDetails data with name fetched Successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(sportsDetailsGetByName));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("sportsDetails data fetching with name was unsuccessful.");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
