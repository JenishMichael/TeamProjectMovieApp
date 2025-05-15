package com.java.CapStoneProject.service;

import com.java.CapStoneProject.domain.User;
import com.java.CapStoneProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements IUserService
{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserNameAndUserPassword(String username, String password)
    {
        User user=userRepository. findByUserNameAndUserPassword(username,password);
        return user;
    }
}
