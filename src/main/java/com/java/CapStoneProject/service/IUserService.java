package com.java.CapStoneProject.service;

import com.java.CapStoneProject.domain.User;
import com.java.CapStoneProject.exception.UserDoesnotExistsException;

public interface IUserService {
    User saveUser(User user);
    public User findUserByEmailAndPassword(String email, String password) throws UserDoesnotExistsException;
}
