package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplementRepo extends JpaRepository<Supplement, Integer> {

    @Query(value = "select * from supplement where supplement_id = ?1", nativeQuery = true)
    Supplement getSupplementById(String supplementId);

}
