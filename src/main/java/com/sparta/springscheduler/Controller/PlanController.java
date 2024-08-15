package com.sparta.springscheduler.Controller;

import com.sparta.springscheduler.DTO.PlanRequestDto;
import com.sparta.springscheduler.DTO.PlanResponseDto;
import com.sparta.springscheduler.entity.Plan;
import com.sparta.springscheduler.service.PlanService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/plan/{plan_id}")
    public PlanResponseDto searchPlan(@PathVariable int plan_id){
        PlanService planService = new PlanService(jdbcTemplate);
        return planService.searchPlan(plan_id);
    }

    //Json 형태로 이름 또는 edit_date 을 넘겨줄시 Database 에서 일치하는 정보를 불러옴
    @GetMapping("/plan")
    public List<Plan> getPlan(@RequestBody PlanRequestDto planRequestDto){
        PlanService planService = new PlanService(jdbcTemplate);
        return planService.getPlan(planRequestDto);
    }


}
