package com.example.hotelmanagement.dto;

import com.example.hotelmanagement.entity.HotelContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomTypeDTO {

    private HotelContract hotelContract;
}
