package com.vector.authorbookrest2025.exception;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException() {
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }

    public AuthorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorNotFoundException(Throwable cause) {
        super(cause);
    }

    public AuthorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}