package com.ticketbook.service;

import com.ticketbook.dto.TicketBookingRequest;
import com.ticketbook.dto.TicketBookingResponse;

public interface TicketBookingService {

	TicketBookingResponse bookTicket(TicketBookingRequest request);

}
