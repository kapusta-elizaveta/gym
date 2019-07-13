package com.gym.service;

import com.gym.dto.RoomDto;
import com.gym.entity.Room;
import org.apache.coyote.http11.filters.VoidOutputFilter;

import java.util.List;

public interface RoomService {

     List<Room> findAll();

     Room findByName(String name);

     Room findById(Integer id);

     Room save(RoomDto roomDto);

     void deleteById(Integer id);



}
