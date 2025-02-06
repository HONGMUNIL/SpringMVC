package com.korit.springboot_study.dto.request.study;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqAddMajorDto {
    @ApiModelProperty(value = "학과명 ", example = "컴퓨터공학과", required = true)
    @Pattern(regexp = "^[가-힣]+$", message = "학과명은 한글만 입력 가능하며, 공백 없이 작성해야 합니다.")
    private String majorName;

    @ApiModelProperty(value = "학과명2 ", example = "컴퓨터공학과2", required = true)
    @Pattern(regexp = "^[가-힣]+$", message = "학과명은 한글만 입력 가능하며, 공백 없이 작성해야 합니다.")
    private String majorName2;

    @ApiModelProperty(value = "학과명3 ", example = "컴퓨터공학과3", required = true)
    @Pattern(regexp = "^[가-힣]+$", message = "학과명은 한글만 입력 가능하며, 공백 없이 작성해야 합니다.")
    private String majorName3;
}
