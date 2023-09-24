package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.MarkupDTO;
import com.example.hotelmanagement.entity.HotelContract;
import com.example.hotelmanagement.entity.Markup;
import com.example.hotelmanagement.service.MarkupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
public class MarkupController {

    @Autowired
    private MarkupService markupService;

    @PostMapping("/addMarkup")
    public ResponseEntity<HotelContract> addMarkup(@RequestBody MarkupDTO markupDTO) {
        HotelContract savedHotelContract = markupService.addMarkup(markupDTO);
        return new ResponseEntity<>(savedHotelContract, HttpStatus.CREATED);
    }

    @GetMapping("/findAllMarkups")
    public ResponseEntity<List<HotelContract>> findAllMarkups() {
        List<HotelContract> allMarkups = markupService.findAllMarkups();
        return new ResponseEntity<>(allMarkups, HttpStatus.OK);
    }

    @GetMapping("/getMarkupById/{markupId}")
    public ResponseEntity<Markup> getMarkupById(@PathVariable String markupId) {
        Markup markup = markupService.getMarkupById(markupId);

        if (markup != null) {
            return new ResponseEntity<>(markup, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}