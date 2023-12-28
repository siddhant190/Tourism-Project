package com.tourism.Travel_Buddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
        }
@Bean
public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        }

@Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
        .authorizeHttpRequests((requests) -> requests
        .requestMatchers("/user/**").hasAuthority("USER")
        //.requestMatchers("/admin/**").hasAuthority("ADMIN")
        .anyRequest()
        .permitAll()
        ).formLogin(Customizer.withDefaults());

        return httpSecurity.build();

        }
@Bean
public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
        }
}