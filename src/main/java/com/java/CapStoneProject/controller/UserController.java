package com.java.CapStoneProject.controller;

import com.java.CapStoneProject.domain.User;
import com.java.CapStoneProject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        iUserService.saveUser(user);
        return new ResponseEntity<>("User Created", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            User userObj = iUserService.findByUserNameAndUserPassword(user.getUsername(), user.getPassword());

            if (userObj != null) {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Login Successful");
                response.put("username", userObj.getUsername());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred during login", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
