package com.gym.service;

import com.gym.dto.CoachDto;
import com.gym.entity.Coach;

import java.util.List;

public interface CoahService {

    List<Coach> findAll();

    List<Coach> findByName(String name);

    Coach findById(Integer id);

    void deleteById(Integer id);

    Coach save(CoachDto coachDto);

}
