package com.pamir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidationnException extends RuntimeException {
    public RequestValidationnException(String message) {
        super(message);
    }
}
