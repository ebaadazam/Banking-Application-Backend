// security
//package com.ebaad.banking_application.service;
//
//import com.ebaad.banking_application.entity.User;
//import com.ebaad.banking_application.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void registerUser(String username, String password, Set<String> roles) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password)); // Hash the password
//        user.setRoles(roles);
//        userRepository.save(user);
//    }
//}
