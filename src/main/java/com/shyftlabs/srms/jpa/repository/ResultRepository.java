package com.shyftlabs.srms.jpa.repository;


import com.shyftlabs.srms.jpa.entity.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;
import java.util.stream.Stream;

public interface ResultRepository extends CrudRepository<Result, UUID> {

    @Query("select r from Result r " +
            "join fetch r.course c " +
            "join fetch r.student s " +
            "order by c.name, s.firstName, s.familyName")
    Stream<Result> findAllResults();
}
