package com.gym.convertors;


import com.gym.dto.OfficeDto;
import com.gym.entity.Office;
import org.springframework.stereotype.Component;

@Component
public class OfficeConvert {

   public OfficeDto convert(Office office){
        OfficeDto officeDto = new OfficeDto();
        officeDto.setId(office.getId());
        officeDto.setName(office.getName());
        return officeDto;
    }

    public Office convert(OfficeDto officeDto){
        Office office = new Office();
        office.setId(officeDto.getId());
        office.setName(officeDto.getName());
        return office;
    }
}
