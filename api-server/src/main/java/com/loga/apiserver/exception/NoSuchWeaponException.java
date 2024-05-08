package com.loga.apiserver.exception;

public class NoSuchWeaponException extends RuntimeException {
    public NoSuchWeaponException() {
        super();
    }

    public NoSuchWeaponException(String message) {
        super(message);
    }

    public NoSuchWeaponException(Throwable cause) {
        super(cause);
    }

    public NoSuchWeaponException(String message, Throwable cause) {
        super(message, cause);
    }
}
