package org.premanshuray.EmployeeManagementSystem.annotaions;

import jakarta.validation.ConstraintValidator;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {
    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.equals("USER") || value.equals("ADMIN");
    }
}
