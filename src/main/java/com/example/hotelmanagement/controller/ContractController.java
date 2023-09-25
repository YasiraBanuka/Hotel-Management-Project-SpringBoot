package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.ContractDTO;
import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.entity.Contract;
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

//    @PostMapping("/addContract")
//    public ResponseEntity<HotelContract> addContract(@RequestBody ContractDTO contractRequest) {
//        HotelContract savedHotelContract = contractService.addContract(contractRequest);
//        return new ResponseEntity<>(savedHotelContract, HttpStatus.CREATED);
//    }

    @GetMapping("/findAllContracts")
    public ResponseEntity<List<Hotel>> findAllContracts() {
        List<Hotel> allContracts = contractService.findAllContracts();
        return new ResponseEntity<>(allContracts, HttpStatus.OK);
    }

    @GetMapping("/findHotelContractById/{contractId}")
    public ResponseEntity<Contract> findHotelContractById(@PathVariable String contractId) {
        Contract contract = contractService.findHotelContractById(contractId);

        if (contract != null) {
            return new ResponseEntity<>(contract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
