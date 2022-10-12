package com.lotfi.compte.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AlreadyCompteExist extends RuntimeException {
    private String compte;
    private String cin;
    public AlreadyCompteExist(String compte, String cin) {
        super(String.format("%s of cin number %s is already exist",compte,cin));
        this.compte = compte;
        this.cin = cin;
    }

    public String getCompte() {
        return compte;
    }

    public String getCin() {
        return cin;
    }
}
