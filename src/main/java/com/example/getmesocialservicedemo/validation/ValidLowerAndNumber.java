package com.example.getmesocialservicedemo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidLowerAndNumberValidator.class)
@Documented
public @interface ValidLowerAndNumber {
    String message() default "Lower case and numbers only!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
