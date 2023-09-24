package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.HotelDTO;
import com.example.hotelmanagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
@CrossOrigin
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/getHotels")
    public List<HotelDTO> getHotel() {
        return hotelService.getAllHotels();
    }

    @PostMapping("/saveHotel")
    public HotelDTO saveHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.saveHotel(hotelDTO);
    }

    @PutMapping("/updateHotel")
    public HotelDTO updateHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.updateHotel(hotelDTO);
    }

    @PutMapping("/updateHotel/{hotelId}")
    public ResponseEntity<HotelDTO> updateHotelById(@PathVariable int hotelId, @RequestBody HotelDTO updatedHotelDTO) {
        HotelDTO updatedHotel = hotelService.updateHotelById(hotelId, updatedHotelDTO);
        if (updatedHotel != null) {
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteHotel/{hotelId}")
    public ResponseEntity<String> deleteHotelById(@PathVariable int hotelId) {
        boolean deleted = hotelService.deleteHotelById(hotelId);

        if (deleted) {
            // Return a success message in the response body
            String successMessage = "Hotel with ID " + hotelId + " has been deleted successfully.";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } else {
            // Return an error message with a NOT_FOUND status code
            String errorMessage = "Hotel with ID " + hotelId + " was not found.";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getHotelById/{hotelId}")
    public HotelDTO getHotelById(@PathVariable String hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @GetMapping("/getHotelByIdAndAddress/{hotelId}/{address}")
    public HotelDTO getHotelByIdAndAddress(@PathVariable String hotelId, @PathVariable String address) {
        System.out.println("hotel id: " + hotelId + "\t address: " + address);
        return hotelService.getHotelByIdAndAddress(hotelId, address);
    }

    @GetMapping("/getHotelByNameAndAddress/{hotelName}/{address}")
    public HotelDTO getHotelByNameAndAddress(@PathVariable String hotelName, @PathVariable String address) {
        System.out.println("hotel name: " + hotelName + "\t address: " + address);
        return hotelService.getHotelByNameAndAddress(hotelName, address);
    }

}
