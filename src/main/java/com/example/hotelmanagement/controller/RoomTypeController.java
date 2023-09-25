package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.RoomTypeDTO;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.entity.RoomType;
import com.example.hotelmanagement.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping("/addRoomType")
    public ResponseEntity<Contract> addRoomType(@RequestBody RoomTypeDTO roomTypeDTO) {
        Contract savedContract = roomTypeService.addRoomType(roomTypeDTO);
        return new ResponseEntity<>(savedContract, HttpStatus.CREATED);
    }

    @GetMapping("/findAllRoomTypes")
    public ResponseEntity<Iterable<Contract>> findAllRoomTypes() {
        Iterable<Contract> allRoomTypes = roomTypeService.findAllRoomTypes();
        return new ResponseEntity<>(allRoomTypes, HttpStatus.OK);
    }

    @GetMapping("/getRoomTypeById/{roomId}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable String roomId) {
        RoomType roomType = roomTypeService.getRoomTypeById(roomId);

        if (roomType != null) {
            return new ResponseEntity<>(roomType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
