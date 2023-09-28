package com.example.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    private String hotelName;
    private String address;
    private String contactInfo;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Contract> contracts = new HashSet<>();
//    @OneToMany(targetEntity = Contract.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "hotelcontract_fk", referencedColumnName = "hotelId")
//    private List<Contract> contracts;

}
