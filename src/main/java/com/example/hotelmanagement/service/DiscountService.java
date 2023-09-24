package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.DiscountDTO;
import com.example.hotelmanagement.entity.Discount;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.repo.DiscountRepo;
import com.example.hotelmanagement.repo.HotelContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiscountService {

    @Autowired
    private DiscountRepo discountRepo;

    @Autowired
    private HotelContractRepo hotelContractRepo;

    public HotelContract addDiscount(DiscountDTO discountDTO) {
        HotelContract hotelContract = discountDTO.getHotelContract();
        return hotelContractRepo.save(hotelContract);
    }
    public Discount getDiscountById(String discountId) {
        return discountRepo.getDiscountById(discountId);
    }

}
