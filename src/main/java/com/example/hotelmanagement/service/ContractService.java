package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.ContractDTO;
import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.repo.HotelContractRepo;
import com.example.hotelmanagement.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private HotelContractRepo hotelContractRepo;

    public Hotel addHotelContract(ContractDTO contractRequest) {
        Hotel hotel = contractRequest.getHotel();
        return hotelRepo.save(hotel);
    }

    public List<Hotel> findAllContracts() {
        return hotelRepo.findAll();
    }

    public HotelContract findHotelContractById(String contractId) {
        return hotelContractRepo.getHotelContractById(contractId);
    }
}

