package com.gym.service.impl;

import com.gym.convertors.CoachConvert;
import com.gym.dto.CoachDto;
import com.gym.entity.Coach;
import com.gym.myException.CoachNotFoundException;
import com.gym.repository.CoachRepository;
import com.gym.service.CoahService;
import com.gym.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoahService {

    private final CoachRepository coachRepository;

    private final CoachConvert coachConvert;

    private final Validate validate;

    @Autowired
    public CoachServiceImpl(CoachRepository coachRepository, CoachConvert coachConvert, Validate validate) {
        this.coachRepository = coachRepository;
        this.coachConvert = coachConvert;
        this.validate = validate;
    }

    @Override
    public List<Coach> findAll() {
        return coachRepository.findAll();
    }



    @Override
    public List<Coach> findByName(String name) {
        return coachRepository.findByName(name);
    }

    @Override
    public Coach findById(Integer id) {
        Optional<Coach> optionalCoach = coachRepository.findById(id);
        if (optionalCoach.isPresent()){
            return optionalCoach.get();
        } throw new CoachNotFoundException("No such coach");
    }

    @Override
    public void deleteById(Integer id) {
        findById(id);
        coachRepository.deleteById(id);
    }

    @Override
    public Coach save(CoachDto coachDto) {
        if (!validate.correctPhoneNumber(coachDto.getPhoneNumber())){
            throw new IllegalArgumentException("This is not phoneNumber");}
        Coach coach = coachConvert.convert(coachDto);
        return coachRepository.save(coach);
    }
}
