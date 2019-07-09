package com.gym.service;

import com.gym.dto.ScheduleDto;

import java.util.List;

public interface ScheduleService {

    List<ScheduleDto> findByOfficeId(Integer id);

    List<ScheduleDto> findByRoomId(Integer id);

    List<ScheduleDto> findAll();
}
