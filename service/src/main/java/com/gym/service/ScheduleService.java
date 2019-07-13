package com.gym.service;

import com.gym.dto.ScheduleDto;
import com.gym.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> findByOfficeId(Integer id);

    List<Schedule> findByRoomId(Integer id);

    List<Schedule> findAll();

    Schedule save(ScheduleDto scheduleDto);

    Schedule findById(Integer id);

    void deleteById(Integer id);
}
