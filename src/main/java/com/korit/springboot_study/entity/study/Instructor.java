package com.korit.springboot_study.entity.study;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {


    private int instructorId;
    private String instructorName;
}
