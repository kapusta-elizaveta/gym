package com.gym.service;

import com.gym.dto.RoomDto;

import java.util.List;

public interface RoomService {

     List<RoomDto> findAll();

     RoomDto findByName(String name);

     RoomDto findById(Integer id);



}
