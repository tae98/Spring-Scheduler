package com.sparta.springscheduler.service;

import com.sparta.springscheduler.DTO.PlanRequestDto;
import com.sparta.springscheduler.DTO.PlanResponseDto;
import com.sparta.springscheduler.entity.Plan;
import com.sparta.springscheduler.repository.PlanRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class PlanService {
    //jdbcTemplate 선언 & 생성자
    private final JdbcTemplate jdbcTemplate;

    public PlanService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PlanResponseDto createPlan(PlanRequestDto planRequestDto){
        Plan plan = new Plan(planRequestDto);

        PlanRepository planRepository = new PlanRepository(jdbcTemplate);
        Plan publishPlan = planRepository.publish(plan);

        return new PlanResponseDto(publishPlan);
    }
}
