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
public class MarkupDTO {

//    private Contract contract;
    private int markupId;
    private float markupPercentage;

    public MarkupDTO() {
    }

    public MarkupDTO(int markupId, float markupPercentage) {
        this.markupId = markupId;
        this.markupPercentage = markupPercentage;
    }

    public int getMarkupId() {
        return markupId;
    }

    public void setMarkupId(int markupId) {
        this.markupId = markupId;
    }

    public float getMarkupPercentage() {
        return markupPercentage;
    }

    public void setMarkupPercentage(float markupPercentage) {
        this.markupPercentage = markupPercentage;
    }

}
