package com.gym.service.impl;

import com.gym.convertors.RoomConvert;
import com.gym.convertors.ScheduleConvert;
import com.gym.dto.ScheduleDto;
import com.gym.repository.ScheduleRepository;
import com.gym.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final OfficeServiceImpl officeService;

    private final RoomServiceImpl roomService;

    private final ScheduleConvert scheduleConvert;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, OfficeServiceImpl officeService,
                               RoomServiceImpl roomService, RoomConvert roomConvert,
                               ScheduleConvert scheduleConvert) {
        this.scheduleRepository = scheduleRepository;
        this.officeService = officeService;
        this.roomService = roomService;
        this.scheduleConvert = scheduleConvert;
    }

    @Override
    public List<ScheduleDto> findByOfficeId(Integer id) {
        officeService.findById(id);
        return scheduleRepository.findByOfficeId(id)
                .stream()
                .map(scheduleConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDto> findByRoomId(Integer id) {
        roomService.findById(id);
        return scheduleRepository.findByRoomId(id)
                .stream()
                .map(scheduleConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(scheduleConvert::convert)
                .collect(Collectors.toList());
    }
}
