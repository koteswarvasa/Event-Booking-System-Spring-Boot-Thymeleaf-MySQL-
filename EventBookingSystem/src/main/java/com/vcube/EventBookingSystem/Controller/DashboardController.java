package com.vcube.EventBookingSystem.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vcube.EventBookingSystem.Service.EventService;

@Controller
public class DashboardController {

	@Autowired
	private EventService eventService;

	@GetMapping("/dashboard")
	public String dashboard(Model model) {

		model.addAttribute("events", eventService.getAllEvents());

		return "dashboard";
	}
}