package com.sparta.springscheduler.entity;

import com.sparta.springscheduler.DTO.PlanRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Plan {
    private int plan_id;
    private String content;
    private String name;
    private String password;
    private Timestamp create_date; //Timestamp
    private Timestamp edit_date;

    public Plan(PlanRequestDto requestDto){
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }


}
