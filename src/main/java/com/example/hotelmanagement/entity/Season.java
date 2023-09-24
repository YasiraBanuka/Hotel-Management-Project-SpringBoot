package com.example.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

}
