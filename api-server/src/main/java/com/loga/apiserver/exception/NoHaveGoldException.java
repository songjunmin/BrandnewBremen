package com.loga.apiserver.exception;

public class NoHaveGoldException extends RuntimeException {
    public NoHaveGoldException() {
        super();
    }

    public NoHaveGoldException(String message) {
        super(message);
    }

    public NoHaveGoldException(Throwable cause) {
        super(cause);
    }

    public NoHaveGoldException(String message, Throwable cause) {
        super(message, cause);
    }
}
