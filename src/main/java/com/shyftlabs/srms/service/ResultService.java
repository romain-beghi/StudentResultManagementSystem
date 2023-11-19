package com.shyftlabs.srms.service;

import com.shyftlabs.srms.jpa.entity.Result;
import com.shyftlabs.srms.jpa.repository.ResultRepository;
import com.shyftlabs.srms.model.ResultRequest;
import com.shyftlabs.srms.model.ResultResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final CourseService courseService;

    private final StudentService studentService;

    private final ResultRepository resultRepository;

    @Transactional
    public List<ResultResponse> getAllResults() {
        return resultRepository.findAllResults()
                .map(result -> ResultResponse.builder()
                        .course(result.getCourse().getName())
                        .student(result.getStudent().getFullName())
                        .grade(result.getGrade())
                        .build()
                )
                .toList();
    }

    @Transactional
    public void createResult(final ResultRequest resultRequest) {
        final Result result = new Result();
        result.setCourse(courseService.getCourse(resultRequest.getCourse()));
        result.setStudent(studentService.getStudent(resultRequest.getStudent()));
        result.setGrade(resultRequest.getGrade());

        resultRepository.save(result);
    }
}
