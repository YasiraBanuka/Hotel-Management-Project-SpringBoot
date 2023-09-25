package com.example.hotelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private int userId;
    private String userName;
    private String userEmail;
    private String userContact;
    private String userNIC;

    private BookingDTO bookingDTO;
}
