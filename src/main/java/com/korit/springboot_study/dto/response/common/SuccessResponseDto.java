package com.korit.springboot_study.dto.response.common;


import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(description = "성공 응답 DTO")
public class SuccessResponseDto<T> {


    private T data;
    private final int status = 200;
    private final String message = "요청이 성공적으로 처리";
    private final String timestamp = String.valueOf(System.currentTimeMillis());


}
