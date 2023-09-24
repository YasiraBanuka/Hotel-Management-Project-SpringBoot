package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.HotelContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelContractRepo extends JpaRepository<HotelContract, Integer> {

    @Query(value = "select * from hotel_contract where contract_id = ?1", nativeQuery = true)
    HotelContract getHotelContractById(String contractId);

}
