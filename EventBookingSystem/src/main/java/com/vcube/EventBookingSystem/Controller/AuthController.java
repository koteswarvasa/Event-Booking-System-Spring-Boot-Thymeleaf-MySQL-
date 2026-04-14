package com.vcube.EventBookingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vcube.EventBookingSystem.Entity.Users;
import com.vcube.EventBookingSystem.Service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // ✅ This will ALWAYS send user object
    @ModelAttribute("user")
    public Users user() {
        return new Users();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Users user) {
        userService.registerUser(user);
        return "redirect:/login";
    }
}