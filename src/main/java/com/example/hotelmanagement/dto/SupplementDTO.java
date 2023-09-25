package com.example.hotelmanagement.dto;

import com.example.hotelmanagement.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplementDTO {

    private Contract contract;

}
