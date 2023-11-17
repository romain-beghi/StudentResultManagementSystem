package com.shyftlabs.srms.controller;

import com.shyftlabs.srms.jpa.entity.Student;
import com.shyftlabs.srms.jpa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents() {
        return Streamable.of(studentRepository.findAll()).toList();
    }
}
