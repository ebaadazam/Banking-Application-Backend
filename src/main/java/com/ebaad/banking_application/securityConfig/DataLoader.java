//package com.ebaad.banking_application.securityConfig;
//
//import com.ebaad.banking_application.entity.User;
//import com.ebaad.banking_application.repository.UserRepository;
//import com.ebaad.banking_application.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Create an ADMIN user who can access all the end points
//        userService.registerUser("ebaad", "allahebd", Set.of("ADMIN"));
//    }
//}