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
public class Markup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int markupId;
    private float percentage;

    @OneToOne(mappedBy = "markup", cascade = CascadeType.ALL)
    private Season season;

}
