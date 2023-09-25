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
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String checkInDate;
    private String checkOutDate;
    private String paymentMethod;
    private double totalPrice;

    public void setRoomType(RoomType roomType) {
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

}
