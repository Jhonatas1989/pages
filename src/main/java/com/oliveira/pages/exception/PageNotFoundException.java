package com.oliveira.pages.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Page")
public class PageNotFoundException extends RuntimeException {

    public PageNotFoundException(String exception){
        super(exception);
    }
}
