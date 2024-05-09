package com.loga.apiserver.controller.dto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {EnumValidator.class}
)
@Target({ElementType.TYPE, ElementType.TYPE_USE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnum {
    Class<? extends Enum<?>> enumClass();

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean ignoreCase() default false;
}
