package com.gym.controller;


import com.gym.dto.RoomDto;
import com.gym.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "/")
    ResponseEntity<List<RoomDto>> findAll(){
        return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    ResponseEntity<RoomDto> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    ResponseEntity<RoomDto> findByName(@PathVariable("name") String name){
        return new ResponseEntity<>(roomService.findByName(name), HttpStatus.OK);
    }
}
