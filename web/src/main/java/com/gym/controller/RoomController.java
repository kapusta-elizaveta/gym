package com.gym.controller;


import com.gym.dto.RoomDto;
import com.gym.entity.Room;
import com.gym.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<List<Room>> findAll(){
        return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    ResponseEntity<Room> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    ResponseEntity<Room> findByName(@PathVariable("name") String name){
        return new ResponseEntity<>(roomService.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Room> save(@Validated @RequestBody RoomDto roomDto){
        return new ResponseEntity<>(roomService.save(roomDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteById(@RequestParam("id") Integer id){
        roomService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
