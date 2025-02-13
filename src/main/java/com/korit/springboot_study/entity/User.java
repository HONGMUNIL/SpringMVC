package com.korit.springboot_study.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String username;
    @JsonIgnore
    private String password;
    private String name;
    private String email;

    List<UserRole> userRoles;

    private int isAccountNonExpired;
    private int isAccountNonLocked;
    private int isCredentialsNonExpired;
    private int isEnabled;
}