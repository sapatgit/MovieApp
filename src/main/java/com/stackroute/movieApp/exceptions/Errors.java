package com.stackroute.movieApp.exceptions;

import org.springframework.http.HttpStatus;

public class Errors {
    private HttpStatus code;
    private String message;

    public Errors(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
