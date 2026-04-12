package com.vcube.EventBookingSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.EventBookingSystem.Entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{

	
	List<Seat> findByEventId(Long eventId);
}
