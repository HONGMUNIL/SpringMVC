package com.korit.springboot_study.dto.request;


import com.korit.springboot_study.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class ReqAddUserDto {
    @ApiModelProperty(value = "사용자이름", example = "user1234", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$", message = "영문자(소문자, 대문자), 숫자, 밑줄(_)만 허용하며, 4~16자 길이")
    private String username;

    @ApiModelProperty(value = "비밀번호", example = "User12345678!", required = true)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,20}$"
            , message = "대문자, 소문자, 숫자, 특수문자(!@#$%^& 등)를 포함**하며, 8~20자 길이")
    private String password;

    @ApiModelProperty(value = "이메일", example = "1234@1234.com", required = true)
    @Email(message = "이메일은 \"영문, 숫자, ., _, %, +, -\" 조합이 가능하며, 반드시 '@' 기호와 유효한 도메인 형식이 포함되어야 합니다.  ")
    private String email;

    @ApiModelProperty(value = "성명", example = "홍길동", required = true)
    @Pattern(regexp = "^[a-zA-Z가-힣]{2,30}(?:\\s[a-zA-Z가-힣]{2,30})*$"
            , message = "한글, 영문(대소문자), 공백 허용하며, 2~30자 길이")
    private String name;


    public User toUser(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
