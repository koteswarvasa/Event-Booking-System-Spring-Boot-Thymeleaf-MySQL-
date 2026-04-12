package com.vcube.EventBookingSystem.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vcube.EventBookingSystem.Entity.Event;
import com.vcube.EventBookingSystem.Service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	 // Show Create Page
    @GetMapping("/events/create")
    public String showCreatePage(Model model) {
        model.addAttribute("event", new Event());
        return "event-create";
    }

    // Save Event
    @PostMapping("/events/save")
    public String saveEvent(@ModelAttribute Event event) {
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    // List Events
    @GetMapping("/events")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "event-list";
    }

    // View Event Details
    @GetMapping("/events/{id}")
    public String eventDetails(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "event-details";
    }
    
    @GetMapping("/events/search")
    public String searchEvents(@RequestParam String keyword, Model model) {

        List<Event> events = eventService.searchEvents(keyword);

        model.addAttribute("events", events);

        return "event-list";
    }
    
    @GetMapping("/events/filter")
    public String filterEvents(@RequestParam String location,
                               @RequestParam String date,
                               Model model) {

        LocalDate localDate = LocalDate.parse(date);

        List<Event> events = eventService.filterEvents(location, localDate);

        model.addAttribute("events", events);

        return "event-list";
    } 
    
    

}
