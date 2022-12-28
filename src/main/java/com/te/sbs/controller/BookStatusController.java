package com.te.sbs.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.BookStatusCreationDto;
import com.te.sbs.response.AppResponse;
import com.te.sbs.service.BookStatusServiceInterface;

@RestController
@RequestMapping(path="/bookstatus")
public class BookStatusController {

	@Autowired
	private AppResponse response;

	@Autowired
	private BookStatusServiceInterface bookStatusService;

	@PostMapping("/bookStatusCreation")
	public ResponseEntity<AppResponse> bookStatusCreation(@RequestBody BookStatusCreationDto bookStatusCreationDto) {
		BookStatusCreationDto bookStatusCreation = bookStatusService.bookStatusCreation(bookStatusCreationDto);
		if (bookStatusCreation != null) {
			response.setError(false);
			response.setMessage("BookStatus Created successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(bookStatusCreationDto));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("BookStatus Creation was unsucessfull");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
