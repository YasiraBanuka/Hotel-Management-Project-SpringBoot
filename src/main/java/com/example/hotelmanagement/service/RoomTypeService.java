package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.RoomTypeDTO;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.entity.RoomType;
import com.example.hotelmanagement.repo.HotelContractRepo;
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
    private HotelContractRepo hotelContractRepo;

    public HotelContract addRoomType(RoomTypeDTO roomTypeDTO) {
        HotelContract hotelContract = roomTypeDTO.getHotelContract();
        return hotelContractRepo.save(hotelContract);
    }

    public List<HotelContract> findAllRoomTypes() {
        return hotelContractRepo.findAll();
    }

    public RoomType getRoomTypeById(String roomId) {
        return roomTypeRepo.getRoomTypeById(roomId);
    }

}
