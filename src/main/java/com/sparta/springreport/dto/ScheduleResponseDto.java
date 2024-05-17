package com.sparta.springreport.dto;

import com.sparta.springreport.entity.Schedule;
import lombok.Getter;

import java.util.Date;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private Date date;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.username = schedule.getUsername();
        this.contents = schedule.getContents();
        this.date = schedule.getDate();
    }
}