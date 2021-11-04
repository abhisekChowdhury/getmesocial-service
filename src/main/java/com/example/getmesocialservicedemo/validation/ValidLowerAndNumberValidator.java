package com.example.getmesocialservicedemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidLowerAndNumberValidator implements ConstraintValidator<ValidLowerAndNumber,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.matches("[a-z0-1]+"))
            return true;
        return false;
    }
}
