package com.example.assignnment4.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.matches("[a-zA-z .]+"))
        {
            return true;

        }
        else
        {
            return false;
        }
    }
}