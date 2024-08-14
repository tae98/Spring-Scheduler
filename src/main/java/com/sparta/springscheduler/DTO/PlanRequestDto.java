package com.sparta.springscheduler.DTO;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
public class PlanRequestDto {
    private int plan_id;
    private String content;
    private String name;
    private String password;
    private Timestamp create_date;
    private Timestamp edit_date;
}
