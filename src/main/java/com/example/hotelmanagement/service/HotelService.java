package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.HotelDTO;
import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.repo.HotelRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private ModelMapper modelMapper;

    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        // Map the DTO to the Hotel entity
        Hotel hotel = modelMapper.map(hotelDTO, Hotel.class);

        // Save the hotel entity
        hotel = hotelRepo.save(hotel);

        // Map the saved entity back to DTO
        return modelMapper.map(hotel, HotelDTO.class);
    }


    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotelList = hotelRepo.findAll();
        return modelMapper.map(hotelList, new TypeToken<List<HotelDTO>>(){}.getType());
    }

    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
        return hotelDTO;
    }

    public HotelDTO updateHotelById(int hotelId, HotelDTO updatedHotelDTO) {
        Optional<Hotel> optionalHotel = hotelRepo.findById(hotelId);

        if (optionalHotel.isPresent()) {
            Hotel existingHotel = optionalHotel.get();

            // Update only the fields that are provided in the DTO
            if (updatedHotelDTO.getHotelName() != null) {
                existingHotel.setHotelName(updatedHotelDTO.getHotelName());
            }
            if (updatedHotelDTO.getAddress() != null) {
                existingHotel.setAddress(updatedHotelDTO.getAddress());
            }
            if (updatedHotelDTO.getContactInfo() != null) {
                existingHotel.setContactInfo(updatedHotelDTO.getContactInfo());
            }

            hotelRepo.save(existingHotel);
            return modelMapper.map(existingHotel, HotelDTO.class);
        } else {
            throw new EntityNotFoundException("Hotel not found with ID: " + hotelId);
        }
    }


    public boolean deleteHotel(HotelDTO hotelDTO) {
        hotelRepo.delete(modelMapper.map(hotelDTO, Hotel.class));
        return true;
    }

    public boolean deleteHotelById(int hotelId) {
        Optional<Hotel> optionalHotel = hotelRepo.findById(hotelId);

        if (optionalHotel.isPresent()) {
            Hotel hotelToDelete = optionalHotel.get();
            hotelRepo.delete(hotelToDelete);
            return true;
        } else {
            // Handle the case where the hotel with the provided ID does not exist
            throw new EntityNotFoundException("Hotel not found with ID: " + hotelId);
        }
    }

    public HotelDTO getHotelById(String hotelId) {
        Hotel hotel = hotelRepo.getHotelById(hotelId);
        return modelMapper.map(hotel, HotelDTO.class);
    }

    public HotelDTO getHotelByIdAndAddress(String hotelId, String address) {
        Hotel hotel = hotelRepo.getHotelByIdAndAddress(hotelId, address);
        return modelMapper.map(hotel, HotelDTO.class);
    }

    public HotelDTO getHotelByNameAndAddress(String hotelName, String address) {
        Hotel hotel = hotelRepo.getHotelByNameAndAddress(hotelName, address);
        return modelMapper.map(hotel, HotelDTO.class);
    }
}
