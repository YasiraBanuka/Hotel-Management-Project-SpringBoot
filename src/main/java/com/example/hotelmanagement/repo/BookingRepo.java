package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
}
