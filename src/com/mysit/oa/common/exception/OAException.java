package com.mysit.oa.common.exception;

public class OAException extends RuntimeException {
    private String message;

    public OAException(String message) {
        super(message);
        this.message = message;
    }
}
