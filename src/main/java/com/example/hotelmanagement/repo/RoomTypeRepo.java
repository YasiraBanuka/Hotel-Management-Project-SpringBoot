package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomTypeRepo extends JpaRepository<RoomType, Integer> {

    @Query(value = "select * from room_type where room_id = ?1", nativeQuery = true)
    RoomType getRoomTypeById(String roomId);

}
