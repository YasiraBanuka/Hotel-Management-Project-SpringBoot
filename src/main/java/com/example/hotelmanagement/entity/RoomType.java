package com.example.hotelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Data
@Table(name = "room_type")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    private String typeName;
    private boolean isAvailable;
    private int maxAdults;
    private int noOfRooms;
    private float roomPrice;

    public RoomType() {
    }

    public RoomType(int roomId, String typeName, boolean isAvailable, int maxAdults, int noOfRooms, float roomPrice, Contract contract, Set<Season> seasons, List<Booking> bookings) {
        this.roomId = roomId;
        this.typeName = typeName;
        this.isAvailable = isAvailable;
        this.maxAdults = maxAdults;
        this.noOfRooms = noOfRooms;
        this.roomPrice = roomPrice;
        this.contract = contract;
        this.seasons = seasons;
        this.bookings = bookings;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(int maxAdults) {
        this.maxAdults = maxAdults;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    @ManyToOne
    @JoinColumn(name = "contract_Id")
    @JsonIgnore
    private Contract contract;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @ManyToMany(
            mappedBy = "roomTypes",
            cascade = {CascadeType.ALL}
    )
    private Set<Season> seasons = new HashSet<>();

    @OneToMany(targetEntity = Booking.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_fk", referencedColumnName = "roomId")
    private List<Booking> bookings;

}
