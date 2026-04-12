package com.vcube.EventBookingSystem.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.EventBookingSystem.Entity.Event;
import com.vcube.EventBookingSystem.Repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	
	//save Event 
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}
	
	//Get All Events 
	
	public List<Event>  getAllEvents(){
		return eventRepository.findAll();
	}
	
	// Get Event by ID
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
    
    public List<Event> searchEvents(String keyword) {
        return eventRepository.findByTitleContainingIgnoreCase(keyword);
    }
    
    public List<Event> filterEvents(String location, LocalDate date) {
        return eventRepository
            .findByLocationContainingIgnoreCaseAndDate(location, date);
    }
	

}
