package com.te.sbs.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.BookStatusCreationDto;
import com.te.sbs.entity.BookStatus;
import com.te.sbs.repository.BookStatusRepository;
import com.te.sbs.service.BookStatusServiceInterface;

@Service
public class BookStatusServiceImpl implements BookStatusServiceInterface {
	
	@Autowired
	private BookStatusRepository bookStatusRepository;

	@Override
	public BookStatusCreationDto bookStatusCreation(BookStatusCreationDto bookStatusCreationDto) {
		BookStatus bookStatus = new BookStatus();
		BeanUtils.copyProperties(bookStatusCreationDto, bookStatus);
		bookStatusRepository.save(bookStatus);
		return bookStatusCreationDto;
	}
}
