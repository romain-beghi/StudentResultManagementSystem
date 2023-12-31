package com.shyftlabs.srms.jpa.repository;

import com.shyftlabs.srms.jpa.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {

    Stream<Student> findAllByOrderByCreatedAsc();
}
