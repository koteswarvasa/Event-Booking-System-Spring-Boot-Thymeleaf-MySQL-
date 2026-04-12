package com.vcube.EventBookingSystem.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.EventBookingSystem.Entity.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findByTitleContainingIgnoreCase(String keyword);



List<Event> findByLocationContainingIgnoreCaseAndDate(String location, LocalDate date);
}