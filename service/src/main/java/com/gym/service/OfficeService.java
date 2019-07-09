package com.gym.service;

import com.gym.dto.OfficeDto;
import com.gym.entity.Office;

import java.util.List;

public interface OfficeService {

    List<OfficeDto> findAll();

    OfficeDto findById(Integer id);

    List<OfficeDto> findByName(String name);

    List<OfficeDto> findByCoachId(Integer id);
}
