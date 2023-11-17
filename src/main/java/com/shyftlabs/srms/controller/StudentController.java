package com.shyftlabs.srms.controller;

import com.shyftlabs.srms.jpa.entity.Student;
import com.shyftlabs.srms.jpa.repository.StudentRepository;
import com.shyftlabs.srms.model.StudentRequest;
import com.shyftlabs.srms.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    private final StudentService studentService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents() {
        return Streamable.of(studentRepository.findAll()).toList();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createCompensationRequest(@RequestBody @Valid final StudentRequest studentRequest) {
        studentService.createStudent(studentRequest);
    }
}
