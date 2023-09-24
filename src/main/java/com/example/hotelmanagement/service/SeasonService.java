package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.SeasonDTO;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.entity.Season;
import com.example.hotelmanagement.repo.HotelContractRepo;
import com.example.hotelmanagement.repo.SeasonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeasonService {

    @Autowired
    private HotelContractRepo hotelContractRepo;

    @Autowired
    private SeasonRepo seasonRepo;

    public HotelContract addSeason(SeasonDTO seasonDTO) {
        HotelContract hotelContract = seasonDTO.getHotelContract();
        return hotelContractRepo.save(hotelContract);
    }

    public List<HotelContract> findAllSeasons() {
        return hotelContractRepo.findAll();
    }

    public Season getSeasonById(String seasonId) {
        return seasonRepo.getSeasonById(seasonId);
    }

}
