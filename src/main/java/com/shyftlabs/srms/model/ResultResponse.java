package com.shyftlabs.srms.model;

import com.shyftlabs.srms.jpa.entity.Grade;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultResponse {

    private String course;

    private String student;

    private Grade grade;
}
