package com.shyftlabs.srms.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "FAMILYNAME", nullable = false)
    private String familyName;

    @Column(name = "DATE_BIRTH", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "EMAIL", nullable = false)
    private String email;
}
