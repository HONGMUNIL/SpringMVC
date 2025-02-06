package com.korit.springboot_study.dto.request.study;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqAddInstructorDto {
    @ApiModelProperty(value = "교수 이름", example = "교수", required = true)
    @Pattern(regexp = "^[가-힣]+$", message = "교수명은 한글만 입력 가능하며, 공백 없이 작성해야 합니다.")
    private String instructorName;
}
