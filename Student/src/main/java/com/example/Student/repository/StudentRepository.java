package com.example.Student.repository;

import com.example.Student.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAllBySchoolId(Long schoolId);
}
