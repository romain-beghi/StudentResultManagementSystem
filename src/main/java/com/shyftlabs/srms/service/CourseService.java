package com.shyftlabs.srms.service;

import com.shyftlabs.srms.jpa.entity.Course;
import com.shyftlabs.srms.jpa.repository.CourseRepository;
import com.shyftlabs.srms.model.CourseRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public List<Course> getAllCourses() {
        return courseRepository.findAllByOrderByName().toList();
    }

    @Transactional
    public void createCourse(final CourseRequest courseRequest) {
        final Course course = new Course();
        course.setName(courseRequest.getName());

        courseRepository.save(course);
    }

    @Transactional
    public void deleteCourse(final UUID uuid) {
        courseRepository.deleteById(uuid);
    }
}
