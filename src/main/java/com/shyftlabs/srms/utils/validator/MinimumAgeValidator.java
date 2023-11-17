package com.shyftlabs.srms.utils.validator;

import com.shyftlabs.srms.utils.constraint.MinimumAge;
import com.shyftlabs.srms.utils.tools.TimeUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class MinimumAgeValidator implements ConstraintValidator<MinimumAge, CharSequence> {

    private static final Integer MINIMUM_AGE    = 10;

    @Override
    public void initialize(final MinimumAge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now().minusYears(MINIMUM_AGE).plusDays(1).isAfter(TimeUtils.convert(value.toString()));
    }
}