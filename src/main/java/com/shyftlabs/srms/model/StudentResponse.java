package com.shyftlabs.srms.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class StudentResponse {

    private UUID id;

    private String firstName;

    private String familyName;

    private LocalDate dateOfBirth;

    private String email;
}
