package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
