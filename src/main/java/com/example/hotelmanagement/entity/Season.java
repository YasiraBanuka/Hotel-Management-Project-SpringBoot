package com.example.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seasonId;
    private String seasonName;
    private String fromDate;
    private String toDate;

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
