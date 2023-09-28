package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.SupplementDTO;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.entity.Supplement;
import com.example.hotelmanagement.repo.ContractRepo;
import com.example.hotelmanagement.repo.SupplementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplementService {

//    @Autowired
//    private ContractRepo contractRepo;
//
//    @Autowired
//    private SupplementRepo supplementRepo;
//
//    public Contract addSupplement(SupplementDTO supplementDTO) {
//        Contract contract = supplementDTO.getContract();
//        return contractRepo.save(contract);
//    }
//
//    public List<Contract> findAllSupplements() {
//        return contractRepo.findAll();
//    }
//
//    public Supplement getSupplementById(String supplementId) {
//        return supplementRepo.getSupplementById(supplementId);
//    }

}
