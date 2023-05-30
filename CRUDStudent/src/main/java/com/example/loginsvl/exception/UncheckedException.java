package com.example.loginsvl.exception;

public class UncheckedException extends RuntimeException{
    public UncheckedException() {
        super();
    }

    public UncheckedException(String message) {
        super(message);
    }
}
