package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.study.Instructor;
import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.StudentStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentStudyRepository {

    @Autowired
    private StudentStudyMapper studentStudyMapper;

    public Optional<List<Major>> findMajorAll() {
        List<Major> foundMajors = studentStudyMapper.selectMajorsAll();

        return foundMajors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundMajors);
    }

    public Optional<List<Instructor>> findInstructorAll() {
        List<Instructor> foundInstructors = studentStudyMapper.selectInstructorsAll();

        return foundInstructors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundInstructors);
    }

    public Optional<Major> saveMajor(Major major) throws DuplicateKeyException {
        try {
            studentStudyMapper.insertMajor(major); //이건 성공횟수
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(e.getMessage(),
                    Map.of("majorName", "이미 존재하는 학과명입니다"));
        }

        return Optional.ofNullable(new Major(major.getMajorId(), major.getMajorName()));//위에서 예외터지면 실행 안됨
    }

    public Optional<Instructor> saveInstructor(Instructor instructor) throws DuplicateKeyException {
        try {
            studentStudyMapper.insertInstructor(instructor); //이건 성공횟수
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(e.getMessage(),
                    Map.of("instructorName", "이미 존재하는 교수명입니다"));
        }

        return Optional.ofNullable(new Instructor(instructor.getInstructorId(), instructor.getInstructorName()));//위에서 예외터지면 실행 안됨
    }

    public Optional<Major> updateMajor(Major major) throws DuplicateKeyException {
        try {
            if(studentStudyMapper.updateMaJorName(major) < 1){
                return Optional.empty();
            }
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("majorName", "잘못된 수정 요청입니다"));

        }
        return Optional.ofNullable(major);
    }
}
