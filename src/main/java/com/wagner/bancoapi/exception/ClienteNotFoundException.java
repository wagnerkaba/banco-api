package com.wagner.bancoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception {
    public ClienteNotFoundException(Long id) {
        super("Cliente not found with id:" + id);
    }
}
