package com.gym.controller;

import com.gym.dto.OfficeDto;
import com.gym.entity.Office;
import com.gym.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<OfficeDto>> findAll(){return new ResponseEntity<>(officeService.findAll(), HttpStatus.OK);}

    @GetMapping(value = "/{id}")
    ResponseEntity<OfficeDto> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(officeService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    ResponseEntity<List<OfficeDto>> findByName(@PathVariable("name") String name){
        return new ResponseEntity<>(officeService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/findCoachId/{coach_id}")
    ResponseEntity<List<OfficeDto>> findByCoachId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(officeService.findByCoachId(id), HttpStatus.OK);
    }
}
