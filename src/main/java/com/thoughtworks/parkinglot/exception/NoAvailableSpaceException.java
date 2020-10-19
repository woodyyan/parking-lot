package com.thoughtworks.parkinglot.exception;

public class NoAvailableSpaceException extends RuntimeException {
    public NoAvailableSpaceException(String message) {
        super(message);
    }
}
