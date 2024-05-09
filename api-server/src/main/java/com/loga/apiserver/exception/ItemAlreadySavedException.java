package com.loga.apiserver.exception;

public class ItemAlreadySavedException extends RuntimeException {
    public ItemAlreadySavedException() {
        super();
    }

    public ItemAlreadySavedException(String message) {
        super(message);
    }

    public ItemAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemAlreadySavedException(Throwable cause) {
        super(cause);
    }
}
