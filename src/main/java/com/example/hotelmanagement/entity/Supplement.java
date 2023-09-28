package com.example.hotelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Data
@Table(name = "supplement")
public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplementId;
    private String supplementName;

    public Supplement() {
    }

    public Supplement(int supplementId, String supplementName) {
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

    @ManyToMany(mappedBy = "supplements", cascade = {CascadeType.ALL})
    private Set<Season> seasons = new HashSet<>();

}
