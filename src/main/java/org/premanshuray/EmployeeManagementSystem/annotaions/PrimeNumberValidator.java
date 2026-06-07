package org.premanshuray.EmployeeManagementSystem.annotaions;

import jakarta.validation.ConstraintValidator;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumber, Integer> {
    @Override
    public boolean isValid(Integer value, jakarta.validation.ConstraintValidatorContext context) {
        if (value == null || value < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
