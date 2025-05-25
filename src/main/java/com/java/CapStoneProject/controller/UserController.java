package com.java.CapStoneProject.controller;

import com.java.CapStoneProject.domain.User;
import com.java.CapStoneProject.exception.UserDoesnotExistsException;
import com.java.CapStoneProject.service.ITokenGenerator;
import com.java.CapStoneProject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final IUserService iUserService;
    private ITokenGenerator iTokenGenerator;

    @Autowired
    public UserController(IUserService iUserService, ITokenGenerator iTokenGenerator) {
        this.iUserService = iUserService;
        this.iTokenGenerator = iTokenGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        iUserService.saveUser(user);
        return new ResponseEntity<>("User Created", HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    public ResponseEntity loginUser(@RequestBody User user) throws UserDoesnotExistsException {
//        try {
//            User u=iUserService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
//            System.out.println("check 1");
//            Map<String, String> secretkey = new HashMap<>();
//            if(u.getEmail().equals(user.getEmail()))
//            {
//                secretkey = iTokenGenerator.generateToken(user);
//                System.out.println(secretkey);
//            }
//            System.out.println("check 2");
//            return new ResponseEntity(secretkey, HttpStatus.OK);
//        }
//        catch (UserDoesnotExistsException e) {
//            return new ResponseEntity("User does not exists",HttpStatus.NOT_FOUND);
//        }
//        catch (Exception e) {
//            return new ResponseEntity("Network Error", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) {
        try {
            User u = iUserService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());

            if (u == null) {
                return new ResponseEntity("User does not exist", HttpStatus.NOT_FOUND);
            }

            Map<String, String> secretkey = new HashMap<>();
            secretkey = iTokenGenerator.generateToken(u);  // Use user from DB, not incoming user
            System.out.println(secretkey);

            return new ResponseEntity(secretkey, HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();  // Print the real error on your console
            return new ResponseEntity("Network Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
