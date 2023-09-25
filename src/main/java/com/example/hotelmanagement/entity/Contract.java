package com.example.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    private String startDate;
    private String endDate;
    private String termsAndConditions;

    @OneToMany(targetEntity = Markup.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "markup_fk", referencedColumnName = "contractId")
    private List<Markup> markups;

    @OneToMany(targetEntity = Season.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "season_fk", referencedColumnName = "contractId")
    private List<Season> seasons;

    @OneToMany(targetEntity = Supplement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "supplement_fk", referencedColumnName = "contractId")
    private List<Supplement> supplements;

    @OneToMany(targetEntity = RoomType.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "roomType_fk", referencedColumnName = "contractId")
    private List<RoomType> roomTypes;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_fk")
    private Discount discount;

}
