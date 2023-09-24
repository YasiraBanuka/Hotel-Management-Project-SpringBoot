package com.example.hotelmanagement.dto;

import com.example.hotelmanagement.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractDTO {

    private Hotel hotel;

}
