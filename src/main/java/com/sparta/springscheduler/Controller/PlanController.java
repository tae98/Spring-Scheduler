package com.sparta.springscheduler.Controller;

import com.sparta.springscheduler.DTO.PlanRequestDto;
import com.sparta.springscheduler.DTO.PlanResponseDto;
import com.sparta.springscheduler.service.PlanService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlanController {
    //jdbcTemplate 선언 & 생성자
    private final JdbcTemplate jdbcTemplate;

    public PlanController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Post Method body 를 받아 새로운 일정 생성
    @PostMapping("/plan")
    public PlanResponseDto publishPlan(@RequestBody PlanRequestDto planRequestDto){
        PlanService planService = new PlanService(jdbcTemplate);
        return planService.createPlan(planRequestDto);
    }


}
