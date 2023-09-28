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
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seasonId;
    private String seasonName;
    private String fromDate;
    private String toDate;

    public Season() {
    }

    public Season(int seasonId, String seasonName, String fromDate, String toDate, Contract contract, Markup markup, Set<Supplement> supplements, Set<RoomType> roomTypes) {
        this.seasonId = seasonId;
        this.seasonName = seasonName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.contract = contract;
        this.markup = markup;
        this.supplements = supplements;
        this.roomTypes = roomTypes;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
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

    @OneToOne
    @JoinColumn(name = "markup_Id", referencedColumnName = "markupId")
    private Markup markup;

    @ManyToMany
    @JoinTable(
            name = "season_supplement",
            joinColumns = @JoinColumn(name = "season_id"),
            inverseJoinColumns = @JoinColumn(name = "supplement_id")
    )
    private Set<Supplement> supplements = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "season_roomtype",
            joinColumns = @JoinColumn(name = "season_id"),
            inverseJoinColumns = @JoinColumn(name = "roomtype_id")
    )
    private Set<RoomType> roomTypes = new HashSet<>();

}
