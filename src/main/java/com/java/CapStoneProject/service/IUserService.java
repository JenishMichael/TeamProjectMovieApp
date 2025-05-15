package com.java.CapStoneProject.service;

import com.java.CapStoneProject.domain.User;

public interface IUserService {
    User saveUser(User user);
    public User findByUserNameAndUserPassword(String username, String password);
}
