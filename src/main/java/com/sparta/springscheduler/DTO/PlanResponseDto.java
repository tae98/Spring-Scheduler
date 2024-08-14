package com.sparta.springscheduler.DTO;

import com.sparta.springscheduler.entity.Plan;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
public class PlanResponseDto {
    private int plan_id;
    private String content;
    private String name;
    private Timestamp create_date;
    private Timestamp edit_date;

    //Dto 생성자
    public PlanResponseDto(Plan plan){
        this.plan_id = plan.getPlan_id();
        this.content = plan.getContent();
        this.name = plan.getName();
        this.create_date = plan.getCreate_date();
        this.edit_date = plan.getEdit_date();
    }

}
