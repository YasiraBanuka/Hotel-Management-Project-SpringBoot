package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.MarkupDTO;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.entity.Markup;
import com.example.hotelmanagement.repo.HotelContractRepo;
import com.example.hotelmanagement.repo.MarkupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarkupService {

    @Autowired
    private HotelContractRepo hotelContractRepo;

    @Autowired
    private MarkupRepo markupRepo;

    public HotelContract addMarkup(MarkupDTO markupDTO) {
        HotelContract hotelContract = markupDTO.getHotelContract();
        return hotelContractRepo.save(hotelContract);
    }

    public List<HotelContract> findAllMarkups() {
        return hotelContractRepo.findAll();
    }

    public Markup getMarkupById(String markupId) {
        return markupRepo.getMarkupById(markupId);
    }
}
