package com.gym.service.impl;

import com.gym.convertors.CoachConvert;
import com.gym.dto.CoachDto;
import com.gym.entity.Coach;
import com.gym.myException.CoachNotFoundException;
import com.gym.repository.CoachRepository;
import com.gym.service.CoahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl implements CoahService {

    private final CoachRepository coachRepository;

    private final CoachConvert coachConvert;

    @Autowired
    public CoachServiceImpl(CoachRepository coachRepository, CoachConvert coachConvert) {
        this.coachRepository = coachRepository;
        this.coachConvert = coachConvert;
    }

    @Override
    public List<CoachDto> findAll() {
        return coachRepository.findAll()
                .stream()
                .map(coachConvert::convert).collect(Collectors.toList());
    }



    @Override
    public List<CoachDto> findByName(String name) {
        return coachRepository.findByName(name)
                .stream()
                .map(coachConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public CoachDto findById(Integer id) {
        Optional<Coach> optionalCoach = coachRepository.findById(id);
        if (optionalCoach.isPresent()){
            return coachConvert.convert(optionalCoach.get());
        } throw new CoachNotFoundException("No such coach");
    }

    @Override
    public void deleteById(Integer id) {
        findById(id);
        coachRepository.deleteById(id);
    }

//    @Override
//    public CoachDto save(CoachDto coachDto) {
//
//        return null;
//    }
}
