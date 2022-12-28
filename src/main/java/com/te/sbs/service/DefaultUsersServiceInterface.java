package com.te.sbs.service;

import java.util.List;

import com.te.sbs.dto.DefaultUserDetailswithIdDto;
import com.te.sbs.dto.DefaultUsersFetchDto;
import com.te.sbs.dto.DefaultUsersGetAllDto;
import com.te.sbs.dto.DefaultUsersRegisterDto;
import com.te.sbs.dto.DefaultUsersUpdateDto;



public interface DefaultUsersServiceInterface {
	
	DefaultUsersRegisterDto userRegister(DefaultUsersRegisterDto userRegisterDto);
	
    DefaultUsersUpdateDto defaultUsersUpdation(DefaultUsersUpdateDto defaultUsersUpdateDto);
    
    Boolean defaultUsersDeletion(DefaultUsersFetchDto defaultUsersFetchDto);
    
    List<DefaultUsersGetAllDto> defaultUsersgetAll();
    
    DefaultUserDetailswithIdDto defaultUsersgetById(Short defaultUserId);
}
