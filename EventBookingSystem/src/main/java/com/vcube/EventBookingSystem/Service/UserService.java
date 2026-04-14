package com.vcube.EventBookingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vcube.EventBookingSystem.Entity.Users;
import com.vcube.EventBookingSystem.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    public void registerUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // ✅ MUST
        user.setRole("USER");
        userRepository.save(user);
    }
    

//    public Users registerUser(Users user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole("USER");
//        return userRepository.save(user);
//    }
}
