package com.ticketbook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ticketbook.dto.TicketBookingRequest;
import com.ticketbook.dto.TicketBookingResponse;
import com.ticketbook.entity.Passenger;
import com.ticketbook.entity.TicketBooking;
import com.ticketbook.entity.TrainDetails;
import com.ticketbook.exceptions.TrainDetailsNotFoundException;
import com.ticketbook.exceptions.UserNotFoundException;
import com.ticketbook.repository.PassengerRepository;
import com.ticketbook.repository.TicketBookingRepository;
import com.ticketbook.repository.TrainDetailsRepository;
import com.ticketbook.service.TicketBookingService;
import com.ticketbook.user.entity.User;
import com.ticketbook.user.repository.UserRepository;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {
	private static final Logger logger = LoggerFactory.getLogger(TicketBookingServiceImpl.class);

	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private TrainDetailsRepository trainDetailsRepository;
	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public TicketBookingResponse bookTicket(TicketBookingRequest request) {
		logger.info("into bookTicket method of userserviceImpl");
		List<Passenger> passengersList=new ArrayList<Passenger>();
		TicketBookingResponse response=new TicketBookingResponse();
		TicketBooking booking=new TicketBooking();
		Optional<User> userDetails=userRepository.findById(request.getUserId());
		try {
			if(userDetails.isPresent()) {
				logger.info("user details available at users table");
				request.getPassengers().stream().forEach(t -> {
				  Passenger entity=new Passenger();
				  entity.setCity(t.getCity());
				  entity.setGender(t.getGender());
				  entity.setMobileNo(t.getMobileNo());
				  entity.setName(t.getName()); 
				  entity.setState(t.getState());
				  entity.setAge(t.getAge());
				  entity.setIdType(t.getIdType());
				  entity.setIdCard(t.getIdNumber());
				  entity.setPrimaryUserId(request.getUserId());
				  passengersList.add(entity);
			  } );
		  logger.info("passengersList size::" + passengersList.size());
		  List<Passenger> result= passengerRepository.saveAll(passengersList);
		  if(result.size()>0) {
			  logger.info("passengers data saved successfully::"  + result.size());
			  logger.info("request.getUserId():::" + request.getUserId());
			  Optional<TrainDetails>  trainDetails = trainDetailsRepository.findBySourceAndDestination(request.getSource(),request .getDestination());
			  if(trainDetails.isPresent()) {
				  logger.info("request.getUserId()33333:::" + request.getUserId());
				  booking.setPassengerId(request.getUserId());
				  booking.setTravelDate(request.getTravelDate());
				  booking.setTrainNo(trainDetails.get().getTrainNo());
				//  booking.setTravelDate(request.getTravelDate());
				  int randomPIN = (int)(Math.random()*9000)+1000;
				  int randomSeatNumber = (int)(Math.random()*90)+10;
				  booking.setPnr(""+randomPIN);
				  if("first class".equalsIgnoreCase(request.getBookingClass())){
				  booking.setBearthType("first class");
				  booking.setTicketPrice(trainDetails.get().getFirstClassPrice());
				  booking.setSeatNumber("F-SL"+randomSeatNumber);
				  
				  } else if("second class".equalsIgnoreCase(request.getBookingClass())){
				  booking.setBearthType("second class");
				  booking.setTicketPrice(trainDetails.get().getSecondClassPrice());
				  booking.setSeatNumber("S-SL"+randomSeatNumber);
				  
				  }else {
				  booking.setBearthType("General class");
				  booking.setTicketPrice(trainDetails.get().getGeneralClassPrice()); 
				  booking.setSeatNumber("GL"+randomSeatNumber);
				  }
				  booking.setTicketStatus("Success"); 
				  ticketBookingRepository.save(booking); 
				  response.setMessage("booking has been succufull");
				  response.setPnr(""+randomPIN);
				  }
			  else {
				  logger.info("train detailas not available");
				  throw new TrainDetailsNotFoundException("No train details found between the given source and destination");
			  }
		  		}
		  	}
		else {
			throw new UserNotFoundException("User details not found with user id : " + " " + request.getUserId());
		}
	}catch(UserNotFoundException ex) {
		throw new UserNotFoundException("data is not availabe for the user " + " " + request.getUserId() );
	}
		return response;
	}

}
