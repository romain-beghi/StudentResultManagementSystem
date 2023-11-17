package com.shyftlabs.srms.controller;

import com.shyftlabs.srms.model.CourseRequest;
import com.shyftlabs.srms.model.CourseResponse;
import com.shyftlabs.srms.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getStudents() {
        return courseService.getAllCourses();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createCourse(@RequestBody @Valid final CourseRequest courseRequest) {
        courseService.createCourse(courseRequest);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCourse(@PathVariable final UUID uuid) {
        courseService.deleteCourse(uuid);
    }
}