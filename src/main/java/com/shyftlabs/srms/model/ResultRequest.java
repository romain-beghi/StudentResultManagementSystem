package com.shyftlabs.srms.model;

import com.shyftlabs.srms.jpa.entity.Grade;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class ResultRequest {

    @NotNull
    private UUID course;

    @NotNull
    private UUID student;

    @NotNull
    private Grade grade;
}
