package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    @Query(value = "select * from hotel where hotel_id = ?1", nativeQuery = true)
    Hotel getHotelById(String hotelId);

    @Query(value = "select * from hotel where hotel_id=?1 and address=?2", nativeQuery = true)
    Hotel getHotelByIdAndAddress(String hotelId, String address);

    @Query(value = "select * from hotel where hotel_name=?1 and address=?2", nativeQuery = true)
    Hotel getHotelByNameAndAddress(String hotelName, String address);
}
