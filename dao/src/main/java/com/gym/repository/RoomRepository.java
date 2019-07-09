package com.gym.repository;

import com.gym.entity.Client;
import com.gym.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    Room findByName(String name);

}
