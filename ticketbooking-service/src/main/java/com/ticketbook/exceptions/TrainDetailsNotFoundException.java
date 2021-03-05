package com.ticketbook.exceptions;

public class TrainDetailsNotFoundException extends RuntimeException{
	
	public TrainDetailsNotFoundException(String message) {
		super(message);
	}

}
