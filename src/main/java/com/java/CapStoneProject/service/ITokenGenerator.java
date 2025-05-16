package com.java.CapStoneProject.service;

import com.java.CapStoneProject.domain.User;

import java.util.Map;


public interface ITokenGenerator {
    Map<String,String> generateToken(User user);
}
