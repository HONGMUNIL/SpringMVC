package com.korit.springboot_study.mapper;


import com.korit.springboot_study.entity.study.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentStudyMapper{
    List<Major> selectMajorsALl();
    // 단건조회(primary key, 유니크키인경우)
    // Major selectMajorsAll();
}
