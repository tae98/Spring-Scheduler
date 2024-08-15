package com.sparta.springscheduler.repository;

import com.sparta.springscheduler.DTO.PlanRequestDto;
import com.sparta.springscheduler.entity.Plan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Repository
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
    //Service 로부터 plan_id값을 받아 일치하는 데이터를 sql문으로 검색
    public Plan searchbyId(int plan_id){
        String sql ="SELECT name, content, create_date, edit_date FROM Plan where plan_id =?";

        return jdbcTemplate.query(sql,resultSet->{
            if(resultSet.next()){
                Plan plan = new Plan();
                plan.setPlan_id(plan_id);
                plan.setContent(resultSet.getString("content"));
                plan.setName(resultSet.getString("name"));
                plan.setCreate_date(resultSet.getTimestamp("create_date"));
                plan.setEdit_date(resultSet.getTimestamp("edit_date"));
                return plan;
            }
            else{
                return null;
            }
        }, plan_id);
    }

    //이름과 날짜를 service 에서 넘겨받아 sql문으로 일치하는 데이터를 검색
    public List<Plan> findByDateorName(Timestamp editDate, String name) {
        String sql = "SELECT plan_id, content, name, create_date, edit_date FROM Plan WHERE edit_date = ? OR name = ?";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
                Plan plan = new Plan();
                plan.setName(resultSet.getString("name"));
                plan.setContent(resultSet.getString("content"));
                plan.setPlan_id(resultSet.getInt("plan_id"));
                plan.setCreate_date(resultSet.getTimestamp("create_date"));
                plan.setEdit_date(resultSet.getTimestamp("edit_date"));
                return plan;
        }, editDate, name);
    }

    //plan_id를 받아와 sql 문으로 비밀번호 와 plan_id 가 일치할시 내용과 관리자명을 수정
    public void editById(Integer planId, PlanRequestDto planRequestDto) {
        String sql = "UPDATE Plan SET content = ?, name =? WHERE password = ? and plan_id = ?";
        jdbcTemplate.update(sql, planRequestDto.getContent(), planRequestDto.getName(), planRequestDto.getPassword(), planId);
    }

    //plan_id 를 받아와 sql database 에서 일치하는 plan_id & password 의 데이터를 삭제
    public void removeById(int planId, PlanRequestDto planRequestDto) {
        String sql = "DELETE FROM Plan WHERE password = ? and plan_id = ?";
        jdbcTemplate.update(sql, planRequestDto.getPassword(), planId);
    }
}

