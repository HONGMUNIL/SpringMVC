package com.korit.springboot_study.dto.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqAddBookDto {
    @ApiModelProperty(value = "도서명 ", example = "스마트동화", required = true)
    private String bookName;



}
