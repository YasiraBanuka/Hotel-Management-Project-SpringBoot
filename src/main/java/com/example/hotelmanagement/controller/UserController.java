package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dto.UserDTO;
import com.example.hotelmanagement.entity.User;
import com.example.hotelmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/hotelmanagement")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addNewUser")
    public ResponseEntity<User> addNewUser(@RequestBody UserDTO userDTO) {
        User savedUser = userService.addUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
