package com.shyftlabs.srms.controller;

import com.shyftlabs.srms.model.StudentRequest;
import com.shyftlabs.srms.model.StudentResponse;
import com.shyftlabs.srms.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createStudent(@RequestBody @Valid final StudentRequest studentRequest) {
        studentService.createStudent(studentRequest);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable final UUID uuid) {
        studentService.deleteStudent(uuid);
    }
}
