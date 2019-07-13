package com.gym.convertors;

import com.gym.dto.ScheduleDto;
import com.gym.entity.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConvert {

    public ScheduleDto convert(Schedule schedule){
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        scheduleDto.setStartTime(schedule.getStartTime());
        scheduleDto.setEndTime(schedule.getEndTime());
        return  scheduleDto;
    }

   public Schedule convert(ScheduleDto scheduleDto){
        Schedule schedule = new Schedule();
        schedule.setId(scheduleDto.getId());
        schedule.setStartTime(scheduleDto.getStartTime());
        schedule.setEndTime(scheduleDto.getEndTime());
        return schedule;
    }
}
