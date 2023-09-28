package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.ContractDTO;
import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.service.ContractService;
import jakarta.validation.Valid;
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

//    @PostMapping("/saveContract")
//    public void saveContract(@RequestBody ContractDTO contractDTO) {
//        contractService.saveContract(contractDTO);
//    }
    @PostMapping("/saveContract")
    public ResponseEntity<ContractDTO> saveContract(@RequestBody ContractDTO contractDTO) {
        ContractDTO savedContract = contractService.saveContract(contractDTO);

        // Check if the savedContract is not null or handle any validation logic
        if (savedContract != null) {
            return new ResponseEntity<>(savedContract, HttpStatus.CREATED);
        } else {
            // Handle the case where the saveContract operation failed
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    public ResponseEntity<String> saveContract(@Valid @RequestBody ContractDTO contractDTO) {
//        try {
//            // Validate contractDTO
//            if (contractDTO == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Contract data is required");
//            }
//            if (contractDTO.getStartDate() == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Start date is required");
//            }
//            // Delegate the saving to the service
//            contractService.saveContract(contractDTO);
//
//            return ResponseEntity.status(HttpStatus.CREATED).body("Contract saved successfully");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid data: " + e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
//        }
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
