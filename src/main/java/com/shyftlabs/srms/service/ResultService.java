package com.shyftlabs.srms.service;

import com.shyftlabs.srms.jpa.repository.ResultRepository;
import com.shyftlabs.srms.model.ResultResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    @Transactional
    public List<ResultResponse> getAllResults() {
        return resultRepository.findAllResults()
                .map(result -> ResultResponse.builder()
                        .course(result.getCourse().getName())
                        .student(StringUtils.joinWith(StringUtils.SPACE, result.getStudent().getFirstName(), result.getStudent().getFamilyName()))
                        .grade(result.getGrade())
                        .build()
                )
                .toList();
    }
}
