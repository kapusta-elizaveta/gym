package com.gym.service.impl;

import com.gym.convertors.RoomConvert;
import com.gym.dto.RoomDto;
import com.gym.entity.Room;
import com.gym.myException.RoomNotFoundException;
import com.gym.repository.RoomRepository;
import com.gym.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final RoomConvert roomConvert;

    public RoomServiceImpl(RoomRepository roomRepository, RoomConvert roomConvert) {
        this.roomRepository = roomRepository;
        this.roomConvert = roomConvert;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findByName(String name) {
        return roomRepository.findByName(name);
    }

    @Override
    public Room findById(Integer id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()){
           return roomOptional.get();
        } throw new RoomNotFoundException("No such room");
    }

    @Override
    public Room save(RoomDto roomDto) {
        Room room = roomConvert.convert(roomDto);
        return roomRepository.save(room);
    }

    @Override
    public void deleteById(Integer id) {
        this.findById(id);
        roomRepository.deleteById(id);
    }
}
