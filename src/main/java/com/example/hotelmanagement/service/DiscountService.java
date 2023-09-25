package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.DiscountDTO;
import com.example.hotelmanagement.entity.Discount;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.repo.DiscountRepo;
import com.example.hotelmanagement.repo.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiscountService {

    @Autowired
    private DiscountRepo discountRepo;

    @Autowired
    private ContractRepo contractRepo;

    public Contract addDiscount(DiscountDTO discountDTO) {
        Contract contract = discountDTO.getContract();
        return contractRepo.save(contract);
    }
    public Discount getDiscountById(String discountId) {
        return discountRepo.getDiscountById(discountId);
    }

}
