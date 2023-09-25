package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.BookingDTO;
import com.example.hotelmanagement.entity.Booking;
import com.example.hotelmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/addNewBooking")
    public ResponseEntity<Booking> addNewBooking(@RequestBody BookingDTO bookingDTO) {
        Booking savedBooking = bookingService.addNewBooking(bookingDTO);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

}
