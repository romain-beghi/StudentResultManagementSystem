package com.shyftlabs.srms.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CourseResponse {

    private UUID id;

    private String name;
}
