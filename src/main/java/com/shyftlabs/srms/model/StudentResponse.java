package com.shyftlabs.srms.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StudentResponse {

    private String name;

    private LocalDate dateOfBirth;

    private String email;
}
