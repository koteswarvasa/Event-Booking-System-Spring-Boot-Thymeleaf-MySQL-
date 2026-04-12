package com.vcube.EventBookingSystem.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vcube.EventBookingSystem.Entity.Booking;
import com.vcube.EventBookingSystem.Entity.Users;
import com.vcube.EventBookingSystem.Repository.SeatRepository;
import com.vcube.EventBookingSystem.Repository.UserRepository;
import com.vcube.EventBookingSystem.Service.BookingService;

@Controller
public class BookingController {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private UserRepository userRepository;

    // Show seats
    @GetMapping("/events/{eventId}/seats")
    public String showSeats(@PathVariable Long eventId, Model model) {

        model.addAttribute("seats", seatRepository.findByEventId(eventId));

        return "seat-selection";
    }

    // Book seat
    @PostMapping("/book/{seatId}")
    public String bookSeat(@PathVariable Long seatId,
                           Principal principal,
                           Model model) {

        String email = principal.getName();

        Users user = userRepository.findByEmail(email).orElseThrow();

        Long userId = user.getId(); // ✅ REAL USER

        String result = bookingService.bookSeat(seatId, userId);

        model.addAttribute("message", result);

        return "booking-result";
    }
    
    @GetMapping("/bookings")
    public String userBookings(Model model, Principal principal) {

        String email = principal.getName();

        Users user = userRepository.findByEmail(email).orElseThrow();

        List<Booking> bookings = bookingService.getUserBookings(user.getId());

        model.addAttribute("bookings", bookings);

        return "booking-history";
    }
}