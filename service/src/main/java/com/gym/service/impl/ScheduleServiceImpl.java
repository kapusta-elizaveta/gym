package com.gym.service.impl;

import com.gym.convertors.RoomConvert;
import com.gym.convertors.ScheduleConvert;
import com.gym.dto.ScheduleDto;
import com.gym.entity.Schedule;
import com.gym.myException.ScheduleNotFoundException;
import com.gym.repository.ScheduleRepository;
import com.gym.service.ScheduleService;
import com.gym.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final OfficeServiceImpl officeService;

    private final RoomServiceImpl roomService;

    private final ScheduleConvert scheduleConvert;

    private final Validate validate;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, OfficeServiceImpl officeService,
                               RoomServiceImpl roomService, RoomConvert roomConvert,
                               ScheduleConvert scheduleConvert, Validate validate) {
        this.scheduleRepository = scheduleRepository;
        this.officeService = officeService;
        this.roomService = roomService;
        this.scheduleConvert = scheduleConvert;
        this.validate = validate;
    }

    @Override
    public List<Schedule> findByOfficeId(Integer id) {
        officeService.findById(id);
        return scheduleRepository.findByOfficeId(id);
    }

    @Override
    public List<Schedule> findByRoomId(Integer id) {
        roomService.findById(id);
        return scheduleRepository.findByRoomId(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule save(ScheduleDto scheduleDto) {
        if (!validate.correctTime(scheduleDto.getStartTime()) || !validate.correctTime(scheduleDto.getEndTime())){
            throw new IllegalArgumentException("This is not time");
        }
        Schedule schedule = scheduleConvert.convert(scheduleDto);
        schedule.setOffice(officeService.findById(scheduleDto.getOfficeId()));
        schedule.setRoom(roomService.findById(scheduleDto.getRoomId()));
        return  scheduleRepository.save(schedule);
    }

    @Override
    public Schedule findById(Integer id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()){
            return optionalSchedule.get();
        } throw new ScheduleNotFoundException("No sucv schedule");
    }

    @Override
    public void deleteById(Integer id) {
        this.findById(id);
        scheduleRepository.deleteById(id);
    }
}
