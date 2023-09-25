package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.BookingDTO;
import com.example.hotelmanagement.entity.Booking;
import com.example.hotelmanagement.entity.RoomType;
import com.example.hotelmanagement.entity.User;
import com.example.hotelmanagement.repo.BookingRepo;
import com.example.hotelmanagement.repo.RoomTypeRepo;
import com.example.hotelmanagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RoomTypeRepo roomTypeRepo;

    @Autowired
    private UserRepo userRepo;

    public Booking addNewBooking(BookingDTO bookingDTO) {
        // fetch the associated room type
        RoomType roomType = roomTypeRepo.findById(bookingDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("RoomType not found"));

        Booking newBooking = new Booking();
        newBooking.setCheckInDate(bookingDTO.getCheckInDate());
        newBooking.setCheckOutDate(bookingDTO.getCheckOutDate());
        newBooking.setPaymentMethod(bookingDTO.getPaymentMethod());
        newBooking.setTotalPrice(bookingDTO.getTotalPrice());
        newBooking.setRoomType(roomType); // Set the associated RoomType

        return bookingRepo.save(newBooking);
    }

//    public Booking addNewBooking(BookingDTO bookingDTO) {
//        // fetch associated user
//        User user = userRepo.findById(bookingDTO.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Booking newBooking = new Booking();
//        newBooking.setCheckInDate(bookingDTO.getCheckInDate());
//        newBooking.setCheckOutDate(bookingDTO.getCheckOutDate());
//        newBooking.setPaymentMethod(bookingDTO.getPaymentMethod());
//        newBooking.setTotalPrice(bookingDTO.getTotalPrice());
//        newBooking.setUser(user); // Set the associated User
//
//        return bookingRepo.save(newBooking);
//    }

}
