package com.gym.controller;

import com.gym.dto.ScheduleDto;
import com.gym.dto.SubscriptionDto;
import com.gym.service.SubscriptionService;
import com.gym.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping(value = "/")
    ResponseEntity<List<Subscription>> findAll(){
        return new ResponseEntity<>(subscriptionService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/price/{price}")
    ResponseEntity<List<Subscription>> findCheaperSubscription(@PathVariable("price") double price){
        return new ResponseEntity<>(subscriptionService.findCheaperSubscription(price), HttpStatus.OK);

    }

    @GetMapping(value = "/id/{id}")
    ResponseEntity<Subscription> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(subscriptionService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Subscription> save(@Validated @RequestBody SubscriptionDto subscriptionDto){
        return new ResponseEntity<>(subscriptionService.save(subscriptionDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteById(@RequestParam("id") Integer id){
        subscriptionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
