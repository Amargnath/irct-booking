package com.ticketbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbook.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

	Optional<Passenger> findById(int userId);


}
