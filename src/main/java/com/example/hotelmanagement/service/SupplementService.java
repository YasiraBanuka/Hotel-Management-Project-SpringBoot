package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.SupplementDTO;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.entity.Supplement;
import com.example.hotelmanagement.repo.HotelContractRepo;
import com.example.hotelmanagement.repo.SupplementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplementService {

    @Autowired
    private HotelContractRepo hotelContractRepo;

    @Autowired
    private SupplementRepo supplementRepo;

    public HotelContract addSupplement(SupplementDTO supplementDTO) {
        HotelContract hotelContract = supplementDTO.getHotelContract();
        return hotelContractRepo.save(hotelContract);
    }

    public List<HotelContract> findAllSupplements() {
        return hotelContractRepo.findAll();
    }

    public Supplement getSupplementById(String supplementId) {
        return supplementRepo.getSupplementById(supplementId);
    }

}
