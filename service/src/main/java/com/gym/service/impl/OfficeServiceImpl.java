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

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    private final CoachRepository coachRepository;

    private final OfficeConvert officeConvert;

    private final CoachServiceImpl coachService;

    private final RoomServiceImpl roomService;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository, CoachRepository coachRepository, CoachConvert coachConvert, OfficeConvert officeConvert, CoachServiceImpl coachService, RoomServiceImpl roomService) {
        this.officeRepository = officeRepository;
        this.coachRepository = coachRepository;
        this.officeConvert = officeConvert;
        this.coachService = coachService;
        this.roomService = roomService;
    }

    @Override
    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public Office findById(Integer id) {
        Optional<Office> optionalOffice = officeRepository.findById(id);
        if (optionalOffice.isPresent()){
            return optionalOffice.get();
        } throw new OfficeNotFoundException("No such office");
    }

    @Override
    public List<Office> findByName(String name) {
        return officeRepository.findByName(name);
    }

    @Override
    public List<Office> findByCoachId(Integer id) {
        coachService.findById(id);
        return officeRepository.findByCoachId(id);
    }

    @Override
    public Office save(OfficeDto officeDto) {
        Office office = officeConvert.convert(officeDto);
        office.setCoach(coachService.findById(officeDto.getCoachId()));
        office.setRoom(roomService.findById(officeDto.getRoomId()));
        return officeRepository.save(office);
    }

    @Override
    public void deleteById(Integer id) {
        this.findById(id);
        officeRepository.deleteById(id);
    }
}


