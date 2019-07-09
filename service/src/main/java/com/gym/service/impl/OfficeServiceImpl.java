package com.gym.service.impl;

import com.gym.convertors.CoachConvert;
import com.gym.convertors.OfficeConvert;
import com.gym.dto.OfficeDto;
import com.gym.entity.Office;
import com.gym.myException.OfficeNotFoundException;
import com.gym.repository.CoachRepository;
import com.gym.repository.OfficeRepository;
import com.gym.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    private final CoachRepository coachRepository;

    private final OfficeConvert officeConvert;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository, CoachRepository coachRepository, CoachConvert coachConvert, OfficeConvert officeConvert) {
        this.officeRepository = officeRepository;
        this.coachRepository = coachRepository;
        this.officeConvert = officeConvert;
    }

    @Override
    public List<OfficeDto> findAll() {
        return officeRepository.findAll()
                .stream()
                .map(officeConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public OfficeDto findById(Integer id) {
        Optional<Office> optionalOffice = officeRepository.findById(id);
        if (optionalOffice.isPresent()){
            return officeConvert.convert(optionalOffice.get());
        } throw new OfficeNotFoundException("No such office");
    }

    @Override
    public List<OfficeDto> findByName(String name) {
        return officeRepository.findByName(name)
                .stream()
                .map(officeConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<OfficeDto> findByCoachId(Integer id) {
        coachRepository.findById(id);
        return officeRepository.findByCoachId(id)
                .stream()
                .map(officeConvert::convert)
                .collect(Collectors.toList());
    }
}


