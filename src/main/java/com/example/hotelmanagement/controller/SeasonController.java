package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.SeasonDTO;
import com.example.hotelmanagement.entity.Contract;
import com.example.hotelmanagement.entity.Season;
import com.example.hotelmanagement.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
public class SeasonController {

//    @Autowired
//    private SeasonService seasonService;
//
//    @PostMapping("/addSeason")
//    public ResponseEntity<Contract> addSeason(@RequestBody SeasonDTO seasonDTO) {
//        Contract savedContract = seasonService.addSeason(seasonDTO);
//        return new ResponseEntity<>(savedContract, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/findAllSeasons")
//    public ResponseEntity<List<Contract>> findAllSeasons() {
//        List<Contract> allSeasons = seasonService.findAllSeasons();
//        return new ResponseEntity<>(allSeasons, HttpStatus.OK);
//    }
//
//    @GetMapping("/getSeasonById/{seasonId}")
//    public ResponseEntity<Season> getSeasonById(@PathVariable String seasonId) {
//        Season season = seasonService.getSeasonById(seasonId);
//
//        if (season != null) {
//            return new ResponseEntity<>(season, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}
