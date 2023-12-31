package com.shyftlabs.srms.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RESULT", uniqueConstraints = {
        @UniqueConstraint(name = "RESULT_UC", columnNames = {"COURSE_ID", "STUDENT_ID"})
})
public class Result {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @Column(name = "GRADE", length = 5, nullable = false)
    @Enumerated(EnumType.STRING)
    private Grade grade;
}
