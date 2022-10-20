package com.lotfi.compte.exceptions;

public class CinNotExist extends RuntimeException {
    public CinNotExist(String cinClient) {
        super(String.format("%s not exist",cinClient));
    }
}
