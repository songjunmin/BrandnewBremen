package com.loga.apiserver.exception;

public class MaxStatAmountExceededException extends RuntimeException {
    public MaxStatAmountExceededException() {
        super();
    }

    public MaxStatAmountExceededException(String message) {
        super(message);
    }

    public MaxStatAmountExceededException(Throwable cause) {
        super(cause);
    }

    public MaxStatAmountExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
