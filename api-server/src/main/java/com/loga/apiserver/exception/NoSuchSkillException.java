package com.loga.apiserver.exception;

public class NoSuchSkillException extends RuntimeException {
    public NoSuchSkillException() {
        super();
    }

    public NoSuchSkillException(String message) {
        super(message);
    }

    public NoSuchSkillException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchSkillException(Throwable cause) {
        super(cause);
    }
}
