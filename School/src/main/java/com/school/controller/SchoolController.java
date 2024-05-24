package com.school.controller;


import com.school.entity.FullSchoolResponse;
import com.school.entity.School;
import com.school.service.SchoolService;
import jakarta.ws.rs.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school)
    {
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools()
    {
        List<School> list = schoolService.findAllSchools();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/with-student/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(@PathVariable(name = "school-id") Long id)
    {
        return ResponseEntity.ok(schoolService.findSchoolWithStudents(id));
    }


}
