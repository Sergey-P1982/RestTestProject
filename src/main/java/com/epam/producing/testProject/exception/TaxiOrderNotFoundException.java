package com.epam.producing.testProject.exception;

public class TaxiOrderNotFoundException extends RuntimeException {

    public TaxiOrderNotFoundException(Long id) {
        super("Could not found the taxi order " + id);
    }
}
