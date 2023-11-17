package com.shyftlabs.srms.model;

import com.shyftlabs.srms.jpa.entity.Grade;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class ResultRequest {

    @NotNull
    private UUID courseId;

    @NotNull
    private UUID studentId;

    @NotNull
    private Grade grade;
}
