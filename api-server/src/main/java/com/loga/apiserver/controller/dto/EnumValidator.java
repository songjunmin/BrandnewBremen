package com.loga.apiserver.controller.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;

public class EnumValidator implements ConstraintValidator<ValidEnum, Enum> {
    private ValidEnum annotation;
    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Enum enumValue, ConstraintValidatorContext constraintValidatorContext) {
        return enumValue.toString() != null && !ObjectUtils.isEmpty(enumValue);
    }
}
