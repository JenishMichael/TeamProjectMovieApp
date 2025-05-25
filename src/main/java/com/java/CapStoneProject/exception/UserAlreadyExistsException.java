package com.java.CapStoneProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "User already exists.")
public class UserAlreadyExistsException extends Exception{
}
