package com.ticketbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbook.dto.TicketBookingRequest;
import com.ticketbook.dto.TicketBookingResponse;
import com.ticketbook.service.TicketBookingService;


@RestController
@RequestMapping("/trainbooking")
public class TicketBookingController {
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	@PostMapping("/bookticket")
	public TicketBookingResponse bookTicket(@RequestBody TicketBookingRequest request) {
		return ticketBookingService.bookTicket(request);
	}
	
	
	

}
