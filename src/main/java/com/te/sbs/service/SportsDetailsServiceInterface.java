package com.te.sbs.service;

import java.util.List;

import com.te.sbs.dto.SportsDetailsDto;
import com.te.sbs.dto.SportsDetailsFetchDto;

public interface SportsDetailsServiceInterface {

	SportsDetailsDto sportsDetailsCreation(SportsDetailsDto sportsDetailsDto);

	SportsDetailsDto sportsDetailsUpdation(SportsDetailsDto sportsDetailsDto);

	SportsDetailsFetchDto sportsDetailsDeletion(SportsDetailsFetchDto sportsDetailsFetchDto);

	List<SportsDetailsDto> sportsDetailsgetAll();

	SportsDetailsDto sportsDetailsGetByName(String sportsName);
}
