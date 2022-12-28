package com.te.sbs.service;

import com.te.sbs.dto.BookingSportDto;
import com.te.sbs.entity.Booking;
import com.te.sbs.entity.DateReserved;

public interface BookingServiceInterface {
	
//	Booking booking(DateReserved dateReserved);
	
	BookingSportDto bookingSport(Short defaultUsersId, String sportsName, BookingSportDto bookingSportDto);
	
//	Booking booking(Booking booking);
	
}
