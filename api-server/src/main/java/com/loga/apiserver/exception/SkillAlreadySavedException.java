package com.loga.apiserver.exception;

public class SkillAlreadySavedException extends RuntimeException {
    public SkillAlreadySavedException() {
        super();
    }

    public SkillAlreadySavedException(String message) {
        super(message);
    }

    public SkillAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SkillAlreadySavedException(Throwable cause) {
        super(cause);
    }
}
