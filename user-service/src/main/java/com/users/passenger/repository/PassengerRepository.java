package com.users.passenger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.users.passenger.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{



	Optional<Passenger> findByNameAndPassword(String userName, String password);

}
