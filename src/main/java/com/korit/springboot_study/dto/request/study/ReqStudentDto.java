package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@ApiModel(value = "학생정보 조회 학습 DTO")
public class ReqStudentDto {
    //처음설정 그대로 변경불가면 아래 코드
    //변경하고싶으면 @Setter를 설정해야함 (requierd=true)
    @NonNull
    @ApiModelProperty(value = "학생 이름", example = "김준일", required = true)
    private final String name;
    @ApiModelProperty(value = "학생 나이", example = "32", required = false)
    private int age;
}