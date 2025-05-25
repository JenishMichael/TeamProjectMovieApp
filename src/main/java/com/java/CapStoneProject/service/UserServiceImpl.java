package com.java.CapStoneProject.service;

import com.java.CapStoneProject.domain.User;
import com.java.CapStoneProject.exception.UserDoesnotExistsException;
import com.java.CapStoneProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
    public User findUserByEmailAndPassword(String email, String password) throws UserDoesnotExistsException
    {
        User user=userRepository. findByEmailAndPassword(email,password);
        return user;
    }
}
