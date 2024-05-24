package com.example.Student.service;

import com.example.Student.entity.Student;
import com.example.Student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student)
    {
        studentRepository.save(student);
    }

    public List<Student> findAllStudents()
    {
        return (List<Student>) studentRepository.findAll();
    }

    public List<Student> findAllStudentsBySchoolId(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
