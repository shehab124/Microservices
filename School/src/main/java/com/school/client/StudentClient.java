package com.school.client;

import com.school.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STUDENTS")
public interface StudentClient {

    @GetMapping("/api/v1/students/school/{school-id}")
    List<Student> findAllStudentsBySchool(@PathVariable("school-id") Long schoolId);
}
