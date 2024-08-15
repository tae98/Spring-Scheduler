package com.sparta.springscheduler.service;

import com.sparta.springscheduler.DTO.PlanRequestDto;
import com.sparta.springscheduler.DTO.PlanResponseDto;
import com.sparta.springscheduler.entity.Plan;
import com.sparta.springscheduler.repository.PlanRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    //plan_id 가 존재하지않을 시 exception 발생, 존재할 시 repository 에 plan_id 와 json 형태 데이터 전송 하여 editById 실행
    public Integer editPlan(Integer plan_id, PlanRequestDto planRequestDto) {
        PlanRepository planRepository = new PlanRepository(jdbcTemplate);
        Plan editPlan = planRepository.searchbyId(plan_id);

        if(editPlan == null){
            throw new IllegalArgumentException("해당 일정은 존재하지 않습니다");
        }else{
            planRepository.editById(plan_id, planRequestDto);
            return plan_id;
        }
    }

    //lan_id 가 존재하지않을 시 exception 발생, 존재할 시 repository 에 plan_id 와 json 형태 password 데이터 전달 하여 removeById 실행
    public Integer removePlan(int planId, PlanRequestDto planRequestDto) {
        PlanRepository planRepository = new PlanRepository(jdbcTemplate);
        Plan removePlan = planRepository.searchbyId(planId);
        if(removePlan == null){
            throw new IllegalArgumentException("해당 일정은 존재하지 않습니다");
        }else{
            planRepository.removeById(planId, planRequestDto);
            return planId;
        }
    }
}
