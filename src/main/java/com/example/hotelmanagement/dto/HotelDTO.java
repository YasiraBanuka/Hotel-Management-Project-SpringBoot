package com.example.hotelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelDTO {
    private int hotelId;
    private String hotelName;
    private String address;
    private String contactInfo;
}
