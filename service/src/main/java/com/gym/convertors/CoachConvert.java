package com.gym.convertors;

import com.gym.dto.CoachDto;
import com.gym.entity.Coach;
import org.springframework.stereotype.Component;

@Component
public class CoachConvert {

    public CoachDto convert(Coach coach){
        CoachDto coachDto = new CoachDto();
        coachDto.setId(coach.getId());
        coachDto.setEmail(coach.getEmail());
        coachDto.setName(coach.getName());
        coachDto.setPhoneNumber(coach.getPhoneNumber());
        return coachDto;
    }

    public Coach convert(CoachDto coachDto){
        Coach coach = new Coach();
        coach.setId(coachDto.getId());
        coach.setEmail(coachDto.getEmail());
        coach.setName(coachDto.getName());
        coach.setPhoneNumber(coachDto.getPhoneNumber());
        return coach;
    }
}
