package com.loga.apiserver.exception;

public class NoSuchPlayerException extends RuntimeException {
    public NoSuchPlayerException() {
        super();
    }

    public NoSuchPlayerException(String message) {
        super(message);
    }

    public NoSuchPlayerException(Throwable cause) {
        super(cause);
    }

    public NoSuchPlayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
