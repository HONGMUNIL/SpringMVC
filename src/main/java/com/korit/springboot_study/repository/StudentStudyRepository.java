package com.korit.springboot_study.repository;


import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.mapper.StudentStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentStudyRepository {

    @Autowired
    private StudentStudyMapper studentStudyMapper;


    public Optional<List<Major>> findMajorAll(int id) {
        List<Major> foundMajors = studentStudyMapper.selectMajorsALl();
//        if(foundMajors.isEmpty()){
//            return Optional.empty(); //null 리턴
//        }
//        return Optional.ofNullable(foundMajors);
        return foundMajors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundMajors);
        //위의 코드도 사용가능
    }

}
