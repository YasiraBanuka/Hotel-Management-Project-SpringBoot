package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepo extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from hotel_contract where contract_id = ?1", nativeQuery = true)
    Contract getHotelContractById(String contractId);

}
