package com.example.hotelmanagement.dto;

import com.example.hotelmanagement.entity.HotelContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiscountDTO {
    private HotelContract hotelContract;;
}
