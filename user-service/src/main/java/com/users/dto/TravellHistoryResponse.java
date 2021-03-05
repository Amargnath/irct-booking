package com.users.dto;

import java.util.List;

import com.users.passenger.entity.Passenger;

public class TravellHistoryResponse {
	
	public List<Passenger> passengers;

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
	
	

}
