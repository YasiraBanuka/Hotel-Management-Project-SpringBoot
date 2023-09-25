package com.example.hotelmanagement.service;

import com.example.hotelmanagement.dto.UserDTO;
import com.example.hotelmanagement.entity.User;
import com.example.hotelmanagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setUserName(userDTO.getUserName());
        newUser.setUserEmail(userDTO.getUserEmail());
        newUser.setUserContact(userDTO.getUserContact());
        newUser.setUserNIC(userDTO.getUserNIC());

        return userRepo.save(newUser);
    }

}
