package com.example.hotelmanagement.dto;

import com.example.hotelmanagement.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class DiscountDTO {
//    private Contract contract;
    private int discountId;
    private String discountName;
    private float discountPercentage;

    public DiscountDTO() {
    }

    public DiscountDTO(int discountId, String discountName, float discountPercentage) {
        this.discountId = discountId;
        this.discountName = discountName;
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}

