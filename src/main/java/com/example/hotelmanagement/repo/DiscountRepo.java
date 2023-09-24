package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiscountRepo extends JpaRepository<Discount, Integer> {

    @Query(value = "select * from discount where discount_id = ?1", nativeQuery = true)
    Discount getDiscountById(String discountId);
}
