package com.te.sbs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.SportsDetailsDto;
import com.te.sbs.dto.SportsDetailsFetchDto;
import com.te.sbs.entity.SportsDetails;
import com.te.sbs.repository.SportsDetailsRepository;
import com.te.sbs.service.SportsDetailsServiceInterface;

@Service
public class SportsDetailsServiceImpl implements SportsDetailsServiceInterface {
	
	@Autowired
	private SportsDetailsRepository sportsDetailsRepository;

	@Override
	public SportsDetailsDto sportsDetailsCreation(SportsDetailsDto sportsDetailsDto) {
		SportsDetails sportsDetails = new SportsDetails();
		BeanUtils.copyProperties(sportsDetailsDto, sportsDetails);
		sportsDetailsRepository.save(sportsDetails);
		return sportsDetailsDto;
	}

	@Override
	public List<SportsDetailsDto> sportsDetailsgetAll() {
		List<SportsDetails> sportDetailsDb = sportsDetailsRepository.findAll();
		List<SportsDetailsDto> list = new ArrayList<SportsDetailsDto>();
		sportDetailsDb.forEach((i)-> list.add(new SportsDetailsDto(i.getSportsName(),i.getDescription(),i.getPriceHourly())));
		return list;
	}

	@Override
	public SportsDetailsDto sportsDetailsUpdation(SportsDetailsDto sportsDetailsDto) {
		  SportsDetails sportsDetailsDb = sportsDetailsRepository.findById(sportsDetailsDto.getSportsName()).orElse(null);
		   if(sportsDetailsDb!=null) {
			   BeanUtils.copyProperties(sportsDetailsDto, sportsDetailsDb);
			  sportsDetailsRepository.save(sportsDetailsDb);
			  return sportsDetailsDto;
		   }
		  return null;
	}

	@Override
	public SportsDetailsFetchDto sportsDetailsDeletion(SportsDetailsFetchDto sportsDetailsFetchDto) {
		SportsDetails sportDetailsDb = sportsDetailsRepository.findById(sportsDetailsFetchDto.getSportsName()).orElse(null);
		
		if(sportDetailsDb!=null) {
			sportsDetailsRepository.deleteById(sportsDetailsFetchDto.getSportsName());
			return sportsDetailsFetchDto;
		}
		return null;
	}

	@Override
	public SportsDetailsDto sportsDetailsGetByName(String sportsName) {
		Optional<SportsDetails> sportsDetailsDb = sportsDetailsRepository.findById(sportsName);
		if(sportsDetailsDb!=null) {
			SportsDetails sportsDetails = sportsDetailsDb.get();
			SportsDetailsDto sportsDetailsDto = new SportsDetailsDto();
			BeanUtils.copyProperties(sportsDetails, sportsDetailsDto);
			return sportsDetailsDto; 	
		}
		return null;
	}
}
