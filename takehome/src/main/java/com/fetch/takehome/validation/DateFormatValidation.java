package com.fetch.takehome.validation;

import com.fetch.takehome.utils.ReceiptUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateFormatValidation implements ConstraintValidator<DateValidator,String> {
    @Override
    public void initialize(DateValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return ReceiptUtils.isValidDate(s);
    }
}
