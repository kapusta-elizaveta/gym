package com.gym.controller;

import com.gym.dto.SaleSubscriptionDto;
import com.gym.service.SaleSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saleSubscriptions")
public class SaleSubscriptionController {

    private final SaleSubscriptionService saleSubscriptionService;

    @Autowired
    public SaleSubscriptionController(SaleSubscriptionService saleSubscriptionService) {
        this.saleSubscriptionService = saleSubscriptionService;
    }

    @GetMapping(value = "/clientId/{clientId}")
    ResponseEntity<List<SaleSubscriptionDto>> findByClientId(@PathVariable("clientId") Integer id){
        return new ResponseEntity<>(saleSubscriptionService.findByClientId(id), HttpStatus.OK);
    }

    @GetMapping(value = "subscriptionId/{subscriptionId}")
    ResponseEntity<List<SaleSubscriptionDto>> findBySubscriptionId(@PathVariable("subscriptionId") Integer id){
        return new ResponseEntity<>(saleSubscriptionService.findBySubscriptionId(id), HttpStatus.OK);
    }
}
