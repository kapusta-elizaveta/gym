package com.gym.service;

import com.gym.dto.SubscriptionDto;
import com.gym.entity.Subscription;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    List<SubscriptionDto> findAll();

    List<SubscriptionDto> findCheaperSubscription(double price);

    SubscriptionDto findById(Integer id);


}
