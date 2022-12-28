package com.te.sbs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.DefaultUserDetailswithIdDto;
import com.te.sbs.dto.DefaultUsersFetchDto;
import com.te.sbs.dto.DefaultUsersGetAllDto;
import com.te.sbs.dto.DefaultUsersRegisterDto;
import com.te.sbs.dto.DefaultUsersUpdateDto;
import com.te.sbs.entity.DefaultUsers;
import com.te.sbs.exceptions.UserNotFoundException;
import com.te.sbs.repository.DefaultUsersRepository;
import com.te.sbs.service.DefaultUsersServiceInterface;

@Service
public class DefaultUsersServiceImpl implements DefaultUsersServiceInterface{

	@Autowired
	private DefaultUsersRepository defaultUsersRepository;
	
	@Override
	public DefaultUsersRegisterDto userRegister(DefaultUsersRegisterDto userRegisterDto) {
		DefaultUsers defaultUsers = new DefaultUsers();
		BeanUtils.copyProperties(userRegisterDto, defaultUsers);
		defaultUsersRepository.save(defaultUsers);
		return userRegisterDto;
	}

	@Override
	public DefaultUsersUpdateDto defaultUsersUpdation(DefaultUsersUpdateDto defaultUsersUpdateDto) {
		DefaultUsers defaultUserDb = defaultUsersRepository.findById(defaultUsersUpdateDto.getDefaultUsersId())
				.orElseThrow(()-> new UserNotFoundException("User Not Found & Check the entered UserId Once again "));
//		if(defaultUserDb!=null) {
			// Don't copy, if we copy these things will sit & remaining will be gone
//			DefaultUsers defaultUsers = new DefaultUsers();
//			BeanUtils.copyProperties(defaultUsersUpdateDto, defaultUsers);
			defaultUserDb.setEmail(defaultUsersUpdateDto.getEmail());
			defaultUserDb.setPassword(defaultUsersUpdateDto.getPassword());
			defaultUserDb.setUserName(defaultUsersUpdateDto.getUserName());
//			defaultUsersRepository.save(defaultUsers);
			// finally you save in that variable only which you got from Db.
			defaultUsersRepository.save(defaultUserDb);
			return defaultUsersUpdateDto;
//		}
	}

	@Override
	public Boolean defaultUsersDeletion(DefaultUsersFetchDto defaultUsersFetchDto) {
		  DefaultUsers defaultUserDb = defaultUsersRepository.findById(defaultUsersFetchDto.getDefaultUsersId())
		  .orElseThrow(()-> new UserNotFoundException("User Not Found & Check the entered UserId Once again "));
//		  if(defaultUserDb!=null) {
			  defaultUsersRepository.deleteById(defaultUsersFetchDto.getDefaultUsersId());  
			  return true;
//		  }	  
//		  return null;
	}

	@Override
	public List<DefaultUsersGetAllDto> defaultUsersgetAll() {
		List<DefaultUsers> defaultUsersTotalListDb = defaultUsersRepository.findAll();
		List<DefaultUsersGetAllDto> getAll = new ArrayList<DefaultUsersGetAllDto>();
		
		defaultUsersTotalListDb.forEach( (i)-> getAll.add(new DefaultUsersGetAllDto(i.getDefaultUsersId(),
				i.getEmail(), i.getUserName() )));
		return getAll;
	
	}

	@Override
	public DefaultUserDetailswithIdDto defaultUsersgetById(Short defaultUserId) {
		Optional<DefaultUsers> defaultUsersDb = defaultUsersRepository.findById(defaultUserId);
		if(defaultUsersDb!=null) {
			//from Optional we need to get FIRST
			DefaultUsers defaultUsers = defaultUsersDb.get();
			DefaultUserDetailswithIdDto defaultUserDetailswithIdDto = new DefaultUserDetailswithIdDto();
//			BeanUtils.copyProperties(defaultUsersDb, defaultUserDetailswithIdDto);
			BeanUtils.copyProperties(defaultUsers, defaultUserDetailswithIdDto);
			return defaultUserDetailswithIdDto;
		}
		   return null;
	}
	
	
}
