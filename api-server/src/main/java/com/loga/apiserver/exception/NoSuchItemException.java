package com.loga.apiserver.exception;

public class NoSuchItemException extends RuntimeException {
    public NoSuchItemException() {
        super();
    }

    public NoSuchItemException(String message) {
        super(message);
    }

    public NoSuchItemException(Throwable cause) {
        super(cause);
    }

    public NoSuchItemException(String message, Throwable cause) {
        super(message, cause);
    }
}
