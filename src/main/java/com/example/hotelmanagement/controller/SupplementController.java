package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.SupplementDTO;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.entity.Supplement;
import com.example.hotelmanagement.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
public class SupplementController {

    @Autowired
    private SupplementService supplementService;

    @PostMapping("/addSupplement")
    public ResponseEntity<HotelContract> addSupplement(@RequestBody SupplementDTO supplementDTO) {
        HotelContract savedHotelContract = supplementService.addSupplement(supplementDTO);
        return new ResponseEntity<>(savedHotelContract, HttpStatus.CREATED);
    }

    @GetMapping("/findAllSupplements")
    public ResponseEntity<Iterable<HotelContract>> findAllSupplements() {
        Iterable<HotelContract> allSupplements = supplementService.findAllSupplements();
        return new ResponseEntity<>(allSupplements, HttpStatus.OK);
    }

    @GetMapping("/getSupplementById/{supplementId}")
    public ResponseEntity<Supplement> getSupplementById(@PathVariable String supplementId) {
        Supplement supplement = supplementService.getSupplementById(supplementId);

        if (supplement != null) {
            return new ResponseEntity<>(supplement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
