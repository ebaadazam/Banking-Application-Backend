// security
//package com.ebaad.banking_application.controller;
//
//import com.ebaad.banking_application.dto.UserDTO;
//import com.ebaad.banking_application.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/api/auth")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
//        // Assign the "USER" role by default
//        userService.registerUser(userDTO.getUsername(), userDTO.getPassword(), Set.of("USER"));
//        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
//    }
//}