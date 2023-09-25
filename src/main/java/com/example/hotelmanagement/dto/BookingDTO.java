package com.example.hotelmanagement.dto;

import com.example.hotelmanagement.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingDTO {

        private int bookingId;
        private String checkInDate;
        private String checkOutDate;
        private String paymentMethod;
        private double totalPrice;

        private int roomId;

        @OneToOne
        @JoinColumn(name = "user_id", referencedColumnName = "userId")
        private User user;
}
