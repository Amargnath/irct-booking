package com.ticketbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="traindetails")
public class TrainDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainId;
	@Column(name="train_number")
	private String trainNo;
	@Column(name="source_place")
	private String source;
	@Column(name="destination_place")
	private String destination;
	@Column(name="departure_time")
	private String departureTime;
	@Column(name="arrival_time")
	private String arrivalTime;
	@Column(name="distance")
	private String distance;
	@Column(name="travel_time")
	private String travelTime;
	@Column(name="first_class_count")
	private String firstClassCount;
	@Column(name="first_class_price")
	private String firstClassPrice;
	@Column(name="second_class_Count")
	private String secondClassCount;
	@Column(name="second_class_price")
	private String secondClassPrice;
	@Column(name="general_class_count")
	private String generalClassCount;
	@Column(name="general_class_price")
	private String generalClassPrice;
	
	
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	
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
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getFirstClassCount() {
		return firstClassCount;
	}
	public void setFirstClassCount(String firstClassCount) {
		this.firstClassCount = firstClassCount;
	}
	public String getFirstClassPrice() {
		return firstClassPrice;
	}
	public void setFirstClassPrice(String firstClassPrice) {
		this.firstClassPrice = firstClassPrice;
	}
	public String getSecondClassCount() {
		return secondClassCount;
	}
	public void setSecondClassCount(String secondClassCount) {
		this.secondClassCount = secondClassCount;
	}
	public String getSecondClassPrice() {
		return secondClassPrice;
	}
	public void setSecondClassPrice(String secondClassPrice) {
		this.secondClassPrice = secondClassPrice;
	}
	public String getGeneralClassCount() {
		return generalClassCount;
	}
	public void setGeneralClassCount(String generalClassCount) {
		this.generalClassCount = generalClassCount;
	}
	public String getGeneralClassPrice() {
		return generalClassPrice;
	}
	public void setGeneralClassPrice(String generalClassPrice) {
		this.generalClassPrice = generalClassPrice;
	}
	
	
	

}
