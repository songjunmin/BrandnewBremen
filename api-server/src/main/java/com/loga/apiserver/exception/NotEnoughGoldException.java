package com.loga.apiserver.exception;

public class NotEnoughGoldException extends RuntimeException {
    public NotEnoughGoldException() {
        super();
    }

    public NotEnoughGoldException(String message) {
        super(message);
    }

    public NotEnoughGoldException(Throwable cause) {
        super(cause);
    }

    public NotEnoughGoldException(String message, Throwable cause) {
        super(message, cause);
    }
}
