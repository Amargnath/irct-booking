package com.ticketbook.dto;

import org.springframework.http.HttpStatus;

public class TicketBookingResponse {
	
	
	/*
	 * private String trainNo; private String pnr; private String seatNumber;
	 * //private String state; private String bearthType; private String
	 * ticketPrice; private String ticketStatus;
	 */
	private String message;
	private String pnr;
	private HttpStatus errorCode;
	
	
	
	public TicketBookingResponse() {
		super();
	}
	public TicketBookingResponse(String message, HttpStatus badRequest) {
		super();
		this.message = message;
		this.errorCode = badRequest;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	
	
	
	
	
	
	
	
	

}
