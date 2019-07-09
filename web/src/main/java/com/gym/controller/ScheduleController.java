package com.gym.controller;

import com.gym.dto.ScheduleDto;
import com.gym.entity.Schedule;
import com.gym.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = "/")
    ResponseEntity<List<ScheduleDto>> findAll(){
        return new ResponseEntity<>(scheduleService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/roomId/{roomId}")
    ResponseEntity<List<ScheduleDto>> findByRoomId(@PathVariable("roomId")Integer id){
        return new ResponseEntity<>(scheduleService.findByRoomId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/officeId/{officeId}")
    ResponseEntity<List<ScheduleDto>> findByOfficeId(@PathVariable("officeId") Integer id){
        return new ResponseEntity<>(scheduleService.findByOfficeId(id), HttpStatus.OK);
    }
}
