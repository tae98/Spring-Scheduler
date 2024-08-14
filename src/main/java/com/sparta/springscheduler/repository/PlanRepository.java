package com.sparta.springscheduler.repository;

import com.sparta.springscheduler.entity.Plan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PlanRepository {
    //jdbcTemplate 선언 & 생성자
    private final JdbcTemplate jdbcTemplate;

    public PlanRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Plan 을 sql database 에 삽입
    public  Plan publish(Plan plan) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO Plan (content, name, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, plan.getContent());
            preparedStatement.setString(2, plan.getName());
            preparedStatement.setString(3, plan.getPassword());
            return preparedStatement;
        }, keyHolder);

        int planId = keyHolder.getKey().intValue();
        plan.setPlan_id(planId);

        return plan;
    }
}
