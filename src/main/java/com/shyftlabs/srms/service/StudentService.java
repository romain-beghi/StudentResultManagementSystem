package com.shyftlabs.srms.service;

import com.shyftlabs.srms.jpa.entity.Student;
import com.shyftlabs.srms.jpa.repository.StudentRepository;
import com.shyftlabs.srms.model.StudentRequest;
import com.shyftlabs.srms.model.StudentResponse;
import com.shyftlabs.srms.utils.exception.SrmsException;
import com.shyftlabs.srms.utils.tools.TimeUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAllByOrderByCreatedAsc()
                .map(student -> StudentResponse.builder()
                        .id(student.getId())
                        .firstName(student.getFirstName())
                        .familyName(student.getFamilyName())
                        .dateOfBirth(student.getDateOfBirth())
                        .email(student.getEmail())
                        .build()
                )
                .toList();
    }

    public Student getStudent(final UUID uuid) {
        return studentRepository.findById(uuid)
                .orElseThrow(() -> new SrmsException("No student found"));
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

    @Transactional
    public void deleteStudent(final UUID uuid) {
        studentRepository.deleteById(uuid);
    }
}
