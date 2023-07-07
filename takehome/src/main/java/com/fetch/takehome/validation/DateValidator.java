package com.fetch.takehome.validation;

import com.fetch.takehome.constants.ReceiptProcessorConstants;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateFormatValidation.class)
public @interface DateValidator {

    public String message() default ReceiptProcessorConstants.DATE_VALIDATION_MESSAGE;
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
