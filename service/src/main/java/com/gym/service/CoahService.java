package com.gym.service;

import com.gym.dto.CoachDto;
import com.gym.entity.Coach;

import java.util.List;

public interface CoahService {

    List<CoachDto> findAll();

    List<CoachDto> findByName(String name);

    CoachDto findById(Integer id);

    void deleteById(Integer id);

  //  CoachDto save(CoachDto coachDto);

}
