package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.DiscountDTO;
import com.example.hotelmanagement.entity.Discount;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    // add discount
    @PostMapping("/addDiscount")
    public ResponseEntity<HotelContract> addDiscount(@RequestBody DiscountDTO discountDTO) {
        HotelContract savedHotelContract = discountService.addDiscount(discountDTO);
        return new ResponseEntity<>(savedHotelContract, HttpStatus.CREATED);
    }

    @GetMapping("/getDiscountById/{discountId}")
    public ResponseEntity<Discount> getDiscountById(@PathVariable String discountId) {
        Discount discount = discountService.getDiscountById(discountId);
        if (discount != null) {
            return new ResponseEntity<>(discount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
