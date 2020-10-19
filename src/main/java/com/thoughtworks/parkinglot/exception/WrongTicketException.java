package com.thoughtworks.parkinglot.exception;

public class WrongTicketException extends RuntimeException {
    public WrongTicketException(String message) {
        super(message);
    }
}
