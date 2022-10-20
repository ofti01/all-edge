package com.lotfi.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFound extends RuntimeException {

    public RessourceNotFound(String cin) {
        super(String.format("Client with CIN %s not found", cin));
    }
}
