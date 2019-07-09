package com.gym.repository;

import com.gym.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    List<Schedule> findByOfficeId(Integer id);

    List<Schedule> findByRoomId(Integer id);
}
