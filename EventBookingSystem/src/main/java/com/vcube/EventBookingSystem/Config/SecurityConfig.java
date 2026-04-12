package com.vcube.EventBookingSystem.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.vcube.EventBookingSystem.Service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	
        http

            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/login", "/register", "/css/**").permitAll()
                    .anyRequest().authenticated()
            )
            
            
            .userDetailsService(userDetailsService)
            
            .formLogin(form -> form
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/dashboard", true)
                    .failureUrl("/login?error=true")
                    .permitAll()
            )

            .logout(logout -> logout
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
            );

        return http.build();
    }
}