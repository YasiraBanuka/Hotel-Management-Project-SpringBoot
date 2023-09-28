package com.example.hotelmanagement.dto;

import com.example.hotelmanagement.entity.*;

import java.util.List;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class ContractDTO {

    private Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    private int contractId;
    private String startDate;
    private String endDate;
    private String termsAndConditions;

    public ContractDTO() {

    }

    public ContractDTO(Hotel hotel, int contractId, String startDate, String endDate, String termsAndConditions, List<MarkupDTO> markups, List<SupplementDTO> supplements, List<SeasonDTO> seasons, List<RoomTypeDTO> roomTypes, DiscountDTO discount) {
        this.hotel = hotel;
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.termsAndConditions = termsAndConditions;
        this.markups = markups;
        this.supplements = supplements;
        this.seasons = seasons;
        this.roomTypes = roomTypes;
        this.discount = discount;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    private List<MarkupDTO> markups;

    public List<MarkupDTO> getMarkups() {
        return markups;
    }

    public void setMarkups(List<MarkupDTO> markups) {
        this.markups = markups;
    }

    private List<SupplementDTO> supplements;

    public List<SupplementDTO> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<SupplementDTO> supplements) {
        this.supplements = supplements;
    }

    private List<SeasonDTO> seasons;

    public List<SeasonDTO> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonDTO> seasons) {
        this.seasons = seasons;
    }

    private List<RoomTypeDTO> roomTypes;

    public List<RoomTypeDTO> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypeDTO> roomTypes) {
        this.roomTypes = roomTypes;
    }

    private DiscountDTO discount;

    public DiscountDTO getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountDTO discount) {
        this.discount = discount;
    }

}
