package com.shyftlabs.srms.service;

import com.shyftlabs.srms.jpa.entity.Student;
import com.shyftlabs.srms.jpa.repository.StudentRepository;
import com.shyftlabs.srms.model.StudentRequest;
import com.shyftlabs.srms.utils.tools.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void createStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setFamilyName(studentRequest.getFamilyName());
        student.setDateOfBirth(TimeUtils.convert(studentRequest.getDateOfBirth()));
        student.setEmail(studentRequest.getEmail());

        studentRepository.save(student);
    }
}
