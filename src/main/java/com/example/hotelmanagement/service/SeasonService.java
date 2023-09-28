package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.SeasonDTO;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.entity.Season;
import com.example.hotelmanagement.repo.ContractRepo;
import com.example.hotelmanagement.repo.SeasonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeasonService {

//    @Autowired
//    private ContractRepo contractRepo;
//
//    @Autowired
//    private SeasonRepo seasonRepo;
//
//    public Contract addSeason(SeasonDTO seasonDTO) {
//        Contract contract = seasonDTO.getContract();
//        return contractRepo.save(contract);
//    }
//
//    public List<Contract> findAllSeasons() {
//        return contractRepo.findAll();
//    }
//
//    public Season getSeasonById(String seasonId) {
//        return seasonRepo.getSeasonById(seasonId);
//    }

}
