package com.gym.service.impl;

import com.gym.convertors.SubscriptionConvert;
import com.gym.dto.SubscriptionDto;
import com.gym.myException.SubscriptionNotFoundException;
import com.gym.service.ClientService;
import com.gym.service.SubscriptionService;
import com.gym.entity.Subscription;
import com.gym.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final ClientService clientService;

    private final SubscriptionRepository subscriptionRepository;

    private final SubscriptionConvert subscriptionConvert;

    @Autowired
    public SubscriptionServiceImpl(ClientService clientService, SubscriptionRepository subscriptionRepository,
                                   SubscriptionConvert subscriptionConvert) {
        this.clientService = clientService;
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionConvert = subscriptionConvert;
    }


    @Override
    public List<SubscriptionDto> findAll() {
        return subscriptionRepository.findAll()
                .stream()
                .map(subscriptionConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubscriptionDto> findCheaperSubscription(double price) {
       if (price <=0) throw new IllegalArgumentException("Price is less than 1");
        return subscriptionRepository.findCheaperSubscription(price)
                .stream()
                .map(subscriptionConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionDto findById(Integer id) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);
        if (optionalSubscription.isPresent()){
            return subscriptionConvert.convert(optionalSubscription.get());
        } throw new SubscriptionNotFoundException("No such subscription");
    }
}
