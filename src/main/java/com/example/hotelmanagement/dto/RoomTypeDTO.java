package com.example.hotelmanagement.dto;

import com.example.hotelmanagement.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class RoomTypeDTO {

//    private Contract contract;
    private int roomId;
    private String typeName;
    private boolean isAvailable;
    private int maxAdults;
    private int noOfRooms;
    private float roomPrice;

    public RoomTypeDTO() {
    }

    public RoomTypeDTO(int roomId, String typeName, boolean isAvailable, int maxAdults, int noOfRooms, float roomPrice) {
        this.roomId = roomId;
        this.typeName = typeName;
        this.isAvailable = isAvailable;
        this.maxAdults = maxAdults;
        this.noOfRooms = noOfRooms;
        this.roomPrice = roomPrice;
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
}
