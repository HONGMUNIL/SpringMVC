package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.study.ReqStudentDto;
import com.korit.springboot_study.dto.response.study.RespStudentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@Api(tags = "REST API 수업")
public class FirstRestController {
    //Map<String, Object> 리턴타입 키,밸류면 자동으로 JSON변환
    @GetMapping("/api/hello")
    public Map<String, Object> hello(HttpServletRequest request) {
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        System.out.println(age);
        System.out.println(address);

        return Map.of("name", "김준일");
    }

    @GetMapping("/api/hello2")
    public Map<String, Object> hello2(@RequestParam int age, @RequestParam String address) {

        System.out.println(age);
        System.out.println(address);

        return Map.of("name", "김준일");
    }

    @ApiOperation(value = "학생 조회(일반 for 선형탐색)", notes = "일반 for문을 사용하여 선형 탐색학습")
    @GetMapping("/api/student")
    public Map<String, Object> getStudent(
            @Parameter(description = "조회할 학생 인덱스", required = false)
            @RequestParam(required = false) int studentId
    ) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 11, "name", "최석현", "age", 26));
        students.add(Map.of("id", 22, "name", "백진우", "age", 32));
        students.add(Map.of("id", 33, "name", "이주원", "age", 28));
        students.add(Map.of("id", 44, "name", "정영훈", "age", 26));

        int foundIndex = -1;

        for(int i = 0; i < students.size(); i++) {
            if((Integer) students.get(i).get("id") == studentId) {
                foundIndex = i;
                break;
            }
        }

        if(foundIndex == -1) {
            return Map.of("error", "찾지 못했음");
        }

        return students.get(foundIndex);
    }



    @ApiOperation(value = "학생 조회(일반 for 선형탐색)", notes = "일반 for문을 사용하여 선형 탐색학습")
    @GetMapping("/api/student2")
    public Map<String, Object> getStudent2(@RequestParam int studentId) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 11, "name", "최석현", "age", 26));
        students.add(Map.of("id", 22, "name", "백진우", "age", 32));
        students.add(Map.of("id", 33, "name", "이주원", "age", 28));
        students.add(Map.of("id", 44, "name", "정영훈", "age", 26));

        Map<String, Object> foundStudent = null;

        for(Map<String, Object> student: students) {
            if((Integer) student.get("id") == studentId) {
                foundStudent = student;
                break;
            }
        }

        if(foundStudent == null) {
            return Map.of("error", "찾지 못했음");
        }

        return foundStudent;
    }


    @ApiOperation(value = "학생 조회(stream 탐색)", notes = "Stream을 사용하여 선형 탐색학습")
    @GetMapping("/api/student3")
    public Map<String, Object> getStudent3(@RequestParam int studentId) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 11, "name", "최석현", "age", 26));
        students.add(Map.of("id", 22, "name", "백진우", "age", 32));
        students.add(Map.of("id", 33, "name", "이주원", "age", 28));
        students.add(Map.of("id", 44, "name", "정영훈", "age", 26));

        Map<String, Object> responseData = students.stream()
                .filter(student -> (Integer) student.get("id") == studentId)
                .findFirst()
                .orElse(Map.of("error", "찾지 못했음"));

        return responseData;
    }

    @GetMapping("/api/student4/{studentId}")
    public RespStudentDto getStudent4(
            @ApiParam(value = "학생 ID", required = true)
            @PathVariable int studentId,
            @ModelAttribute
            ReqStudentDto reqStudentDto) {

//        return Map.of("id", studentId, "name", reqStudentDto.getName(), "age", reqStudentDto.getAge());
//        return Map.of("id", 11, "name", reqStudentDto.getName(), "age", reqStudentDto.getAge());
        return new RespStudentDto(100, "홍문일", 30);

    }
}