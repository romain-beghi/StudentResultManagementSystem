package com.shyftlabs.srms.model;

import com.shyftlabs.srms.utils.constraint.MinimumAge;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String familyName;

    @MinimumAge
    private String dateOfBirth;

    @Email(regexp = ".+@.+\\..+")
    private String email;
}
