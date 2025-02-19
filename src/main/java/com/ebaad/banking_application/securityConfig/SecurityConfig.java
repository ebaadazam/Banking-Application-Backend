//package com.ebaad.banking_application.securityConfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/register").permitAll()
//                        .requestMatchers("/api/banking").permitAll()
//                        .requestMatchers("/api/banking/{id}").hasAnyRole("USER", "ADMIN") // Allow USER and ADMIN to access account details
//                        .requestMatchers("/api/banking/name/{accountHolderName}").hasAnyRole("USER", "ADMIN") // Allow USER and ADMIN to access account details by name
//                        .requestMatchers("/api/banking/**").hasRole("ADMIN") // Restrict other endpoints to ADMIN only
//                        .anyRequest().authenticated()
//                )
//                .formLogin(Customizer.withDefaults()); // Enable form-based login
//
//        return http.build();
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
