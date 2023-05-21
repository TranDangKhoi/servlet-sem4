package com.example.loginsvl.exception;

public class UncheckedException extends RuntimeException{
    public UncheckedException() {
    }

    public UncheckedException(String message) {
        super(message);
    }
}
