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
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final RoomConvert roomConvert;

    public RoomServiceImpl(RoomRepository roomRepository, RoomConvert roomConvert) {
        this.roomRepository = roomRepository;
        this.roomConvert = roomConvert;
    }

    @Override
    public List<RoomDto> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(roomConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto findByName(String name) {
        return roomConvert.convert(roomRepository.findByName(name));
    }

    @Override
    public RoomDto findById(Integer id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()){
            return roomConvert.convert(roomOptional.get());
        } throw new RoomNotFoundException("No such room");
    }
}
