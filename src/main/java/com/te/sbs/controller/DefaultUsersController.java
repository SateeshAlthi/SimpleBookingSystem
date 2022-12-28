package com.te.sbs.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.DefaultUserDetailswithIdDto;
import com.te.sbs.dto.DefaultUsersFetchDto;
import com.te.sbs.dto.DefaultUsersGetAllDto;
import com.te.sbs.dto.DefaultUsersRegisterDto;
import com.te.sbs.dto.DefaultUsersUpdateDto;
import com.te.sbs.response.AppResponse;
import com.te.sbs.service.DefaultUsersServiceInterface;

@RestController
@RequestMapping(path="/defaultuser")
public class DefaultUsersController {

	@Autowired
	private AppResponse response;

	@Autowired
	private DefaultUsersServiceInterface defaultUsersService;

	@PostMapping("/defaultUserRegister")
	public ResponseEntity<AppResponse> userRegister(@RequestBody DefaultUsersRegisterDto userRegisterDto) {
		DefaultUsersRegisterDto registeredUser = defaultUsersService.userRegister(userRegisterDto);
		if (registeredUser != null) {
			response.setError(false);
			response.setMessage("User Registered successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(registeredUser));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("User Registration was unsucessfull");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@PostMapping("/defaultUserDelete")
	public ResponseEntity<AppResponse> userDelete(@RequestBody DefaultUsersFetchDto defaultUsersFetchDto) {
		if (Boolean.TRUE.equals(defaultUsersService.defaultUsersDeletion(defaultUsersFetchDto))) {
			response.setError(false);
			response.setMessage("User Deleted successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("User Deletion was unsucessfull");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/defaultUserUpdate")
	public ResponseEntity<AppResponse> userUpdate(@RequestBody DefaultUsersUpdateDto defaultUsersUpdateDto) {
		DefaultUsersUpdateDto defaultUsersUpdation = defaultUsersService.defaultUsersUpdation(defaultUsersUpdateDto);
		if (defaultUsersUpdation != null) {
			response.setError(false);
			response.setMessage("User Updated successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(defaultUsersUpdation));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("User Updation was unsucessfull");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/defaultUsergetAll")
	public ResponseEntity<AppResponse> usergetAll() {
		List<DefaultUsersGetAllDto> defaultUsersgetAll = defaultUsersService.defaultUsersgetAll();
		if (defaultUsersgetAll != null) {
			response.setError(false);
			response.setMessage("User Details Fetched successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(defaultUsersgetAll));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("User Details Fetching was unsucessfull");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/defaultUsersgetById/{defaultUsersId}")
	public ResponseEntity<AppResponse> defaultUsersgetById(@PathVariable Short defaultUsersId) {
		DefaultUserDetailswithIdDto defaultUsersgetById = defaultUsersService.defaultUsersgetById(defaultUsersId);
		if (defaultUsersgetById != null) {
			response.setError(false);
			response.setMessage("User Data Fetched successfully");
			response.setStatus(200);
			response.setDate(LocalDate.now());
			response.setData(Arrays.asList(defaultUsersgetById));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("User Data Fetching was unsucessfull");
			response.setStatus(205);
			response.setDate(LocalDate.now());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
