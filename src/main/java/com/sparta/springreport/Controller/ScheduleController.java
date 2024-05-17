package com.sparta.springreport.Controller;

import com.sparta.springreport.dto.ScheduleRequestDto;
import com.sparta.springreport.dto.ScheduleResponseDto;
import com.sparta.springreport.entity.Schedule;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();
    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);

        Long maxId = scheduleList.size() > 0 ? Collections.max(scheduleList.keySet()) + 1 : 1;
        schedule.setId(maxId);

        scheduleList.put(schedule.getId(), schedule);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules() {
        List<ScheduleResponseDto> responseList = scheduleList.values().stream()
                .map(ScheduleResponseDto::new).toList();

        return responseList;
    }

    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        if(scheduleList.containsKey(id)) {
            Schedule schedule = scheduleList.get(id);

            schedule.update(requestDto);
            return schedule.getId();
        }
        else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않는다");
        }
    }

    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable Long id) {
        if(scheduleList.containsKey(id)) {
            scheduleList.remove(id);
            return id;

        }
        else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않음");
        }
    }
}
