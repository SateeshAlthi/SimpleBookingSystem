package com.te.sbs.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.te.sbs.dto.BookingSportDto;
import com.te.sbs.entity.BookStatus;
import com.te.sbs.entity.Booking;
import com.te.sbs.entity.DefaultUsers;
import com.te.sbs.entity.SportField;
import com.te.sbs.entity.SportsDetails;
import com.te.sbs.exceptions.UserNotFoundException;
import com.te.sbs.repository.BookStatusRepository;
import com.te.sbs.repository.BookingRepository;
import com.te.sbs.repository.DefaultUsersRepository;
import com.te.sbs.repository.SportsDetailsRepository;
import com.te.sbs.service.BookingServiceInterface;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private SportsDetailsRepository sportsDetailsRepository;

	@Autowired
	private BookStatusRepository bookStatusRepository;

//	@Autowired
//	private DateReservedRepository dateReservedRepository;

	// Important
	@Autowired
	private DefaultUsersRepository defaultUsersRepository;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mmm-yyyy hh:mm")
	private Date lastLogin;

//	@Autowired
//	private DefaultUsers defaultUsers;

//	@Autowired
//	private DefaultUsersRegisterDto defaultUsersRegisterDto;

	@Override
	public BookingSportDto bookingSport(Short defaultUsersId, String sportsName, BookingSportDto bookingSportDto) {
		Optional<DefaultUsers> defaultUserDb = defaultUsersRepository.findById(defaultUsersId);
		if (defaultUserDb.isPresent()) {
			DefaultUsers defaultUsers = defaultUserDb.get();

			Booking booking = new Booking();
			BeanUtils.copyProperties(bookingSportDto, booking);

// Booking Entity is having List of Default Users,SportField &  BookStatus 

//			SportField sportField = new SportField();
//			
//			BeanUtils.copyProperties(bookingSportDto, sportField);

			// For Booking Entity we are setting the List of Default Users,SportField &
			// BookStatus
			booking.getDefaultUsers().add(defaultUsers);
//			booking.setSportfield(sportField);

			Optional<SportsDetails> sportDetailsDb = sportsDetailsRepository.findById(sportsName);
			if (sportDetailsDb.isPresent()) {
				SportsDetails sportsDetails = sportDetailsDb.get();
				SportField sportField = new SportField();
				sportField.setSportsName(sportsDetails.getSportsName());
				sportField.setDescription(sportsDetails.getDescription());
				sportField.setPriceHourly(sportsDetails.getPriceHourly());
				sportField.setRequestOn(LocalDateTime.now());
				booking.setSportfield(sportField);

				BeanUtils.copyProperties(bookingSportDto, sportField);
			}

			Optional<BookStatus> findById = bookStatusRepository.findById(1);
			if (findById.isPresent()) {
				BookStatus bookStatus2 = findById.get();
				booking.setBookStatus(bookStatus2);
			}

			bookingRepository.save(booking);

//			Booking save = bookingRepository.save(booking);			
//			defaultUsersRepository.save(defaultUsers);
//			sportFieldRepository.save(sportField);
//			BookStatus bookStatus2 = save.getBookStatus();
//			Optional<BookStatus> findById = bookStatusRepository.findById(bookStatus2.getBookStatusId());
			return bookingSportDto;
		} else {
			throw new UserNotFoundException("User Not Found");
		}
	}
}

//	private Boolean bookingDateAvaiable(Booking booking) {
//		Date startDate = booking.getStartDate();
//		DateReserved dateReserved = new DateReserved();
//		DateReserved dateAvailable = dateReservedRepository.findById(startDate).orElse(null);
//		
//		if(dateAvailable==null) {
//			dateReserved.setBookedDate(startDate);
//			dateReserved.setStatus(true);
//			dateReservedRepository.save(dateReserved);
//			return true;
//		}
//		return false;		
//	}

//	@Override
//	public Booking booking(Booking booking) {
//		if(bookingDateAvaiable(booking)) {
//			
//			SportField sportfield = booking.getSportfield();
//			DefaultUsers defaultUsers = new DefaultUsers();
//			if(defaultUsers!=null) {
//				sportfield.setRequestOn(LocalDateTime.now());
//				Booking save = bookingRepository.save(booking);
//				return save;
//			}
//			
//		}
//		return null;
//	}

//	@Override
//	public Booking booking (DateReserved dateReserved){
//		
//		DateReserved dateReserved2 = new DateReserved();
//
//		Date startDate = dateReserved.getStartDate();
//				
//		DateReserved save = dateReservedRepository.save(null);
//		
//		// TODO Auto-generated method stub
//		return save;
//	}
