package com.school.service;

import com.school.client.StudentClient;
import com.school.entity.FullSchoolResponse;
import com.school.entity.School;
import com.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school)
    {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools()
    {
        return (List<School>) schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolWithStudents(Long id) {
        School school = schoolRepository.findById(id)
                .orElse(School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build()
                );

        var students = studentClient.findAllStudentsBySchool(id);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
