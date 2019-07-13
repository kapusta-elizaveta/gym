package com.gym.convertors;

import com.gym.dto.RoomDto;
import com.gym.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomConvert {

    public RoomDto convert(Room room){
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setName(room.getName());
        return roomDto;
    }

    public Room convert(RoomDto roomDto){
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setName(roomDto.getName());
        return room;
    }


}
