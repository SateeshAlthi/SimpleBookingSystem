package com.te.sbs.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.sbs.exceptions.SportDetailsNotFoundException;
import com.te.sbs.exceptions.UserNotFoundException;
import com.te.sbs.response.AppResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private AppResponse response;
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<AppResponse> exceptionHandler(UserNotFoundException userNotFoundException){
		response.setError(true);
		response.setMessage(userNotFoundException.getMessage());
		response.setStatus(205);
		response.setDate(LocalDate.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SportDetailsNotFoundException.class)
	public ResponseEntity<AppResponse> exceptionHandler(SportDetailsNotFoundException sportDetailsNotFoundException){
		response.setError(true);
		response.setMessage(sportDetailsNotFoundException.getMessage());
		response.setStatus(205);
		response.setDate(LocalDate.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AppResponse> exceptionHandler(Exception exception){
		response.setError(true);
		response.setMessage(exception.getMessage());
		response.setStatus(205);
		response.setDate(LocalDate.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	
}
