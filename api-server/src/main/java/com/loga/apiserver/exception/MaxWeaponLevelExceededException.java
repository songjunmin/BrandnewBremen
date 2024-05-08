package com.loga.apiserver.exception;

public class MaxWeaponLevelExceededException extends RuntimeException {
    public MaxWeaponLevelExceededException() {
        super();
    }

    public MaxWeaponLevelExceededException(String message) {
        super(message);
    }

    public MaxWeaponLevelExceededException(Throwable cause) {
        super(cause);
    }

    public MaxWeaponLevelExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
