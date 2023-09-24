package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.ContractDTO;
import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/addHotelContract")
    public ResponseEntity<Hotel> addHotelContract(@RequestBody ContractDTO contractRequest) {
        Hotel savedHotel = contractService.addHotelContract(contractRequest);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @GetMapping("/findAllContracts")
    public ResponseEntity<List<Hotel>> findAllContracts() {
        List<Hotel> allContracts = contractService.findAllContracts();
        return new ResponseEntity<>(allContracts, HttpStatus.OK);
    }

    @GetMapping("/findHotelContractById/{contractId}")
    public ResponseEntity<HotelContract> findHotelContractById(@PathVariable String contractId) {
        HotelContract hotelContract = contractService.findHotelContractById(contractId);

        if (hotelContract != null) {
            return new ResponseEntity<>(hotelContract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}






//package com.example.hotelmanagement.controller;
//
//import com.example.hotelmanagement.dto.ContractDTO;
//import com.example.hotelmanagement.entity.Hotel;
//import com.example.hotelmanagement.entity.HotelContract;
//import com.example.hotelmanagement.repo.HotelContractRepo;
//import com.example.hotelmanagement.repo.HotelRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "api/v1/hotelmanagement")
//public class ContractController {
//
//    @Autowired
//    private HotelRepo hotelRepo;
//    @Autowired
//    private HotelContractRepo hotelContractRepo;
//
//    @PostMapping("/addHotelContract")
//    public Hotel addHotelContract(@RequestBody ContractDTO contractRequest) {
//        return hotelRepo.save(contractRequest.getHotel());
//    }
//
//    @GetMapping("/findAllContracts")
//    public List<Hotel> findAllContracts() {
//        return hotelRepo.findAll();
//    }
//
//    // get contract details by id
//    @GetMapping("/findHotelContractById/{contractId}")
//    public ResponseEntity<HotelContract> findHotelContractById(@PathVariable String contractId) {
//        // Use the custom query from HotelContractRepo to get the contract by ID
//        HotelContract hotelContract = hotelContractRepo.getHotelContractById(contractId);
//
//        if (hotelContract != null) {
//            return new ResponseEntity<>(hotelContract, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//}
