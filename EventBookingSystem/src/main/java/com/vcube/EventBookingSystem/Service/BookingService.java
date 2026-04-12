package com.vcube.EventBookingSystem.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.EventBookingSystem.Entity.Booking;
import com.vcube.EventBookingSystem.Entity.Seat;
import com.vcube.EventBookingSystem.Repository.BookingRepository;
import com.vcube.EventBookingSystem.Repository.SeatRepository;

@Service
public class BookingService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public String bookSeat(Long seatId, Long userId) {

        Seat seat = seatRepository.findById(seatId).orElseThrow();

        // 🔥 CORE LOGIC
        if (seat.isBooked()) {
            return "Seat already booked!";
        }

        // mark seat booked
        seat.setBooked(true);
        seatRepository.save(seat);

        // create booking
        Booking booking = new Booking();
        booking.setSeat(seat);
        booking.setEvent(seat.getEvent());
        booking.setUserId(userId);
        booking.setBookingTime(LocalDateTime.now());

        bookingRepository.save(booking);

        return "Success";
    }
    
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
