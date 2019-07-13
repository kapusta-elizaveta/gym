package com.gym.service;

import com.gym.dto.SubscriptionDto;
import com.gym.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    List<Subscription> findAll();

    List<Subscription> findCheaperSubscription(double price);

    Subscription findById(Integer id);

    Subscription save(SubscriptionDto subscriptionDto);

    void deleteById(Integer id);


}
