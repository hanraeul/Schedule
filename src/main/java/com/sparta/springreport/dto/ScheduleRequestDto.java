package com.sparta.springreport.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ScheduleRequestDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String password;
    private Date date;
}