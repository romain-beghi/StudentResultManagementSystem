package com.shyftlabs.srms.utils.constraint;

import com.shyftlabs.srms.utils.validator.MinimumAgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@NotNull
@Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
@Constraint(validatedBy = MinimumAgeValidator.class)
@ReportAsSingleViolation
@Documented
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinimumAge {

    String message() default "Invalid age: ${validatedValue}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}