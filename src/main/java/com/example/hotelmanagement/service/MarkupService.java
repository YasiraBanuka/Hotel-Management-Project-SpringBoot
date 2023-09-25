package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.MarkupDTO;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.entity.Markup;
import com.example.hotelmanagement.repo.ContractRepo;
import com.example.hotelmanagement.repo.MarkupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarkupService {

    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private MarkupRepo markupRepo;

    public Contract addMarkup(MarkupDTO markupDTO) {
        Contract contract = markupDTO.getContract();
        return contractRepo.save(contract);
    }

    public List<Contract> findAllMarkups() {
        return contractRepo.findAll();
    }

    public Markup getMarkupById(String markupId) {
        return markupRepo.getMarkupById(markupId);
    }
}
