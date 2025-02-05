package com.korit.springboot_study.controller;

import com.korit.springboot_study.mapper.StudentStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentStudyController {
    @Autowired
    private StudentStudyMapper studentStudyMapper;

    @GetMapping("/api/study/majors")
    public ResponseEntity<?> getMajors(){
        return ResponseEntity.ok().body(studentStudyMapper.selectMajorsALl());
    }

}
