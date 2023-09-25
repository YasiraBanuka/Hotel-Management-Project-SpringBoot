package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.*;
import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.repo.ContractRepo;
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
    private ContractRepo contractRepo;

    public Hotel addHotelContract(ContractDTO contractRequest) {
        Hotel hotel = contractRequest.getHotel();
        return hotelRepo.save(hotel);
    }

    // add hotel contract with all its associated entities
//    public HotelContract addContract(ContractDTO contractRequest) {
//        HotelContract hotelContract = contractRequest.getHotelContract();
//        return hotelContractRepo.save(hotelContract);
//    }

    public List<Hotel> findAllContracts() {
        return hotelRepo.findAll();
    }

    public Contract findHotelContractById(String contractId) {
        return contractRepo.getHotelContractById(contractId);
    }
}

