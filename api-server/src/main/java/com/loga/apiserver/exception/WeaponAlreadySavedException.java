package com.loga.apiserver.exception;

public class WeaponAlreadySavedException extends RuntimeException {
    public WeaponAlreadySavedException() {
        super();
    }

    public WeaponAlreadySavedException(String message) {
        super(message);
    }

    public WeaponAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeaponAlreadySavedException(Throwable cause) {
        super(cause);
    }
}
