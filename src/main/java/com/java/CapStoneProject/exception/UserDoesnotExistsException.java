package com.java.CapStoneProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Movie does'nt exists.")
public class UserDoesnotExistsException extends Exception{

}
