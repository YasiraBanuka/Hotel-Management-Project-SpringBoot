package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.*;
import com.example.hotelmanagement.entity.*;
import com.example.hotelmanagement.repo.ContractRepo;
import com.example.hotelmanagement.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContractService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private ContractRepo contractRepo;

    // Helper method to map MarkupDTO to Markup entity
    private Markup mapMarkup(MarkupDTO markupDTO) {
        Markup markup = new Markup();
        markup.setMarkupId(markupDTO.getMarkupId());
        markup.getMarkupPercentage(markupDTO.getMarkupPercentage());

        return markup;
    }

    // Helper method to map SupplementDTO to Supplement entity
    private Supplement mapSupplement(SupplementDTO supplementDTO) {
        Supplement supplement = new Supplement();
        supplement.setSupplementId(supplementDTO.getSupplementId());
        supplement.setSupplementName(supplementDTO.getSupplementName());

        return supplement;
    }

    // Helper method to map SeasonDTO to Season entity
    private Season mapSeason(SeasonDTO seasonDTO) {
        Season season = new Season();
        season.setSeasonId(seasonDTO.getSeasonId());
        season.setSeasonName(seasonDTO.getSeasonName());
        season.setFromDate(seasonDTO.getFromDate());
        season.setToDate(seasonDTO.getToDate());

        return season;
    }

    // Helper method to map RoomTypeDTO to RoomType entity
    private RoomType mapRoomType(RoomTypeDTO roomTypeDTO) {
        RoomType roomType = new RoomType();
        roomType.setRoomId(roomTypeDTO.getRoomId());
        roomType.setTypeName(roomTypeDTO.getTypeName());
        roomType.setAvailable(roomTypeDTO.isAvailable());
        roomType.setMaxAdults(roomTypeDTO.getMaxAdults());
        roomType.setNoOfRooms(roomTypeDTO.getNoOfRooms());
        roomType.setRoomPrice(roomTypeDTO.getRoomPrice());

        return roomType;
    }

    // Helper method to map DiscountDTO to Discount entity
    private Discount mapDiscount(DiscountDTO discountDTO) {
        Discount discount = new Discount();
        discount.setDiscountId(discountDTO.getDiscountId());
        discount.setDiscountName(discountDTO.getDiscountName());
        discount.setDiscountPercentage(discountDTO.getDiscountPercentage());

        return discount;
    }

    public ContractDTO saveContract(ContractDTO contractDTO) {
        Contract contract = new Contract();

        // Find the associated hotel by its ID
        Optional<Hotel> hotelOptional = hotelRepo.findById(contractDTO.getHotel().getHotelId());
        Hotel hotel = hotelOptional.orElseThrow(() -> new IllegalArgumentException("Hotel not found"));

        // Set the contract's properties
        contract.setHotel(hotel);
        contract.setStartDate(contractDTO.getStartDate());
        contract.setEndDate(contractDTO.getEndDate());
        contract.setTermsAndConditions(contractDTO.getTermsAndConditions());

        // Add markups to the contract
        for (MarkupDTO markupDTO : contractDTO.getMarkups()) {
            Markup markup = mapMarkup(markupDTO);
            contract.addMarkup(markup);
        }

        // Add supplements to the contract
        for (SupplementDTO supplementDTO : contractDTO.getSupplements()) {
            Supplement supplement = mapSupplement(supplementDTO);
            contract.addSupplement(supplement);
        }

        // Add seasons to the contract
        for (SeasonDTO seasonDTO : contractDTO.getSeasons()) {
            Season season = mapSeason(seasonDTO);
            contract.addSeason(season);
        }

        // Add room types to the contract
        for (RoomTypeDTO roomTypeDTO : contractDTO.getRoomTypes()) {
            RoomType roomType = mapRoomType(roomTypeDTO);
            contract.addRoomType(roomType);
        }

        // Add discount to the contract
        DiscountDTO discountDTO = contractDTO.getDiscount();
        Discount discount = mapDiscount(discountDTO);
        contract.addDiscount(discount);

        // save the contract with added markups, supplements, seasons, room types, and discount
        contractRepo.save(contract);
        return contractDTO;
    }

    public List<Hotel> findAllContracts() {
        return hotelRepo.findAll();
    }

    public Contract findHotelContractById(String contractId) {
        return contractRepo.getHotelContractById(contractId);
    }
}

