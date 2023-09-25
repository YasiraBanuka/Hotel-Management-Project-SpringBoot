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
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    private String typeName;
    private boolean isAvailable;
    private int maxAdults;
    private int noOfRooms;
    private float roomPrice;

    @ManyToMany(
            mappedBy = "roomTypes",
            cascade = {CascadeType.ALL}
    )
    private Set<Season> seasons = new HashSet<>();

    @OneToMany(targetEntity = Booking.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_fk", referencedColumnName = "roomId")
    private List<Booking> bookings;

}
