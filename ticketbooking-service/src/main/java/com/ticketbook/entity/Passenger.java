package com.ticketbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Passenger_tb")
public class Passenger {
	
	@Id
	@Column(name = "psg_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "psg_name")
	private String name;
	@Column(name = "psg_gender")
	private String gender;
	@Column(name = "psg_city")
	private String city;
	@Column(name = "psg_state")
	private String state;
	@Column(name = "psg_mobile")
	private String mobileNo;
	@Column(name = "psg_id_type")
	private String idType;
	@Column(name = "psg_id_card")
	private String idCard;
	@Column(name = "psg_age")
	private String age;
	@Column(name = "psg_primary_user_id")
	private int primaryUserId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getPrimaryUserId() {
		return primaryUserId;
	}
	public void setPrimaryUserId(int i) {
		this.primaryUserId = i;
	}
	
	
	
	
	

}
