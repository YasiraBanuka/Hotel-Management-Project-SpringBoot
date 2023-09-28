package com.example.hotelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Data
@Table(name = "markup")
public class Markup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int markupId;
    private float markupPercentage;

    public Markup() {
    }

    public Markup(int markupId, float markupPercentage, Contract contract, Season season) {
        this.markupId = markupId;
        this.markupPercentage = markupPercentage;
        this.contract = contract;
        this.season = season;
    }

    public int getMarkupId() {
        return markupId;
    }

    public void setMarkupId(int markupId) {
        this.markupId = markupId;
    }

    public float getMarkupPercentage(float markupPercentage) {
        return this.markupPercentage;
    }

    public void setMarkupPercentage(float markupPercentage) {
        this.markupPercentage = markupPercentage;
    }

    // map many-to-one relationship with contract
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

    @OneToOne(mappedBy = "markup", cascade = CascadeType.ALL)
    private Season season;

}
