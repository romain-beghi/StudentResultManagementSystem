package com.shyftlabs.srms.service;

import com.shyftlabs.srms.jpa.entity.Student;
import com.shyftlabs.srms.jpa.repository.StudentRepository;
import com.shyftlabs.srms.model.StudentRequest;
import com.shyftlabs.srms.model.StudentResponse;
import com.shyftlabs.srms.utils.tools.TimeUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAllByOrderByCreatedAsc()
                .map(student -> StudentResponse.builder()
                            .name(StringUtils.joinWith(StringUtils.SPACE,student.getFirstName(), student.getFamilyName()))
                            .dateOfBirth(student.getDateOfBirth())
                            .email(student.getEmail())
                        .build()
                )
                .toList();
    }

    @Transactional
    public void createStudent(final StudentRequest studentRequest) {
        final Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setFamilyName(studentRequest.getFamilyName());
        student.setDateOfBirth(TimeUtils.convert(studentRequest.getDateOfBirth()));
        student.setEmail(studentRequest.getEmail());

        studentRepository.save(student);
    }
}
