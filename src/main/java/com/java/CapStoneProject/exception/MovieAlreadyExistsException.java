package com.java.CapStoneProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Movie already exists.")
public class MovieAlreadyExistsException extends Exception{
}
