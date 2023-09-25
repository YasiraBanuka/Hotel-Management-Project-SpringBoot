package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.RoomTypeDTO;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.entity.RoomType;
import com.example.hotelmanagement.repo.ContractRepo;
import com.example.hotelmanagement.repo.RoomTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomTypeService {

    @Autowired
    private RoomTypeRepo roomTypeRepo;

    @Autowired
    private ContractRepo contractRepo;

    public Contract addRoomType(RoomTypeDTO roomTypeDTO) {
        Contract contract = roomTypeDTO.getContract();
        return contractRepo.save(contract);
    }

    public List<Contract> findAllRoomTypes() {
        return contractRepo.findAll();
    }

    public RoomType getRoomTypeById(String roomId) {
        return roomTypeRepo.getRoomTypeById(roomId);
    }

}
