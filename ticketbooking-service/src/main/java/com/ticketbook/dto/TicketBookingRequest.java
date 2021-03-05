package com.ticketbook.dto;

import java.util.List;

import com.ticketbook.entity.Passenger;

public class TicketBookingRequest {
	
	private int userId;
	private String source;
	private String destination;
	private String bookingClass;
	private String travelDate;
	private List<PassengersDto> passengers;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBookingClass() {
		return bookingClass;
	}
	public void setBookingClass(String bookingClass) {
		this.bookingClass = bookingClass;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<PassengersDto> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<PassengersDto> passengers) {
		this.passengers = passengers;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	
	
	
	

}
