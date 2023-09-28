package com.example.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    private String startDate;
    private String endDate;
    private String termsAndConditions;

    public Contract() {

    }

    public Contract(int contractId, String startDate, String endDate, String termsAndConditions, Hotel hotel, Set<Markup> markups, Set<Season> seasons, Set<Supplement> supplements, Set<RoomType> roomTypes, Discount discount) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.termsAndConditions = termsAndConditions;
        this.hotel = hotel;
        this.markups = markups;
        this.seasons = seasons;
        this.supplements = supplements;
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

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<Markup> markups = new HashSet<>();

    public Set<Markup> getMarkups() {
        return markups;
    }

    public void setMarkups(Set<Markup> markups) {
        this.markups = markups;
    }

    public void addMarkup(Markup markup) {
        markup.setContract(this);
        markups.add(markup);
    }

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<Season> seasons = new HashSet<>();

    public Set<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    public void addSeason(Season season) {
        season.setContract(this);
        seasons.add(season);
    }

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<Supplement> supplements = new HashSet<>();

    public Set<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(Set<Supplement> supplements) {
        this.supplements = supplements;
    }

    public void addSupplement(Supplement supplement) {
        supplement.setContract(this);
        supplements.add(supplement);
    }

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<RoomType> roomTypes = new HashSet<>();

    public Set<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(Set<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public void addRoomType(RoomType roomType) {
        roomType.setContract(this);
        roomTypes.add(roomType);
    }

    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL)
    private Discount discount;

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void addDiscount(Discount discount) {
        discount.setContract(this);
        this.discount = discount;
    }
}
