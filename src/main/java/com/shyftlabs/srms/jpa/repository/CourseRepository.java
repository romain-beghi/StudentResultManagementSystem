package com.shyftlabs.srms.jpa.repository;

import com.shyftlabs.srms.jpa.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;
import java.util.stream.Stream;

public interface CourseRepository extends CrudRepository<Course, UUID> {

    Stream<Course> findAllByOrderByName();
}
