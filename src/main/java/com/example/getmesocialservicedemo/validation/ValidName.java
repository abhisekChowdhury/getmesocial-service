package com.example.getmesocialservicedemo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidNameValidator.class)
@Documented
public @interface ValidName {
    String message() default "Not a valid name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}