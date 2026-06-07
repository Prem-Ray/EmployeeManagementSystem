package org.premanshuray.EmployeeManagementSystem.annotaions;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {PrimeNumberValidator.class})
public @interface PrimeNumber {
    String message() default "Number must be Prime";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
