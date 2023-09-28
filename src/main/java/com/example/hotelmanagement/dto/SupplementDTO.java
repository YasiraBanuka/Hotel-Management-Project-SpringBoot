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
public class SupplementDTO {

//    private Contract contract;
    private int supplementId;
    private String supplementName;

    public SupplementDTO() {
    }

    public SupplementDTO(int supplementId, String supplementName) {
        this.supplementId = supplementId;
        this.supplementName = supplementName;
    }

    public int getSupplementId() {
        return supplementId;
    }

    public void setSupplementId(int supplementId) {
        this.supplementId = supplementId;
    }

    public String getSupplementName() {
        return supplementName;
    }

    public void setSupplementName(String supplementName) {
        this.supplementName = supplementName;
    }
}
