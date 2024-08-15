package com.sparta.springscheduler.service;

import com.sparta.springscheduler.DTO.PlanRequestDto;
import com.sparta.springscheduler.DTO.PlanResponseDto;
import com.sparta.springscheduler.entity.Plan;
import com.sparta.springscheduler.repository.PlanRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


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
    //Repository 에 plan_id 넘겨주어 searchbyId  실행
    public PlanResponseDto searchPlan(int plan_id){
        PlanRepository planRepository = new PlanRepository(jdbcTemplate);
        Plan selectPlan = planRepository.searchbyId(plan_id);

        return new PlanResponseDto(selectPlan);
    }

    //Repository 에 이름과 날짜를 넘겨주어 findByDate or Name 실행
    public List<Plan> getPlan(PlanRequestDto planRequestDto) {
        PlanRepository planRepository = new PlanRepository(jdbcTemplate);
        return planRepository.findByDateorName(planRequestDto.getEdit_date(), planRequestDto.getName());
    }
}
