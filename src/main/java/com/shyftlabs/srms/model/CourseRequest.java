package com.shyftlabs.srms.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseRequest {

    @NotBlank
    private String name;
}
