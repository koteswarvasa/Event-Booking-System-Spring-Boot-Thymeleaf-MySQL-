package com.vcube.EventBookingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vcube.EventBookingSystem.Entity.Users;
import com.vcube.EventBookingSystem.Service.UserService;

@Controller
public class AuthController {
	
	@Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Users user) {
        userService.registerUser(user);
        return "redirect:/login";
    }
}