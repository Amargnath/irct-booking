package com.ticketbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbook.entity.TrainDetails;

public interface TrainDetailsRepository extends JpaRepository<TrainDetails, Integer>{

	Optional<TrainDetails> findBySourceAndDestination(String source, String destination);

}


