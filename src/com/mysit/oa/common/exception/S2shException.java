package com.mysit.oa.common.exception;

public class S2shException extends RuntimeException {
    private String message;

    public S2shException(String message) {
        super(message);
        this.message = message;
    }
}
