package com.ticketbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbook.entity.TicketBooking;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer>{

}

