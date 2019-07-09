package com.gym.service.impl;

import com.gym.convertors.SaleSubscriptionConvert;
import com.gym.dto.SaleSubscriptionDto;
import com.gym.entity.SaleSubscription;
import com.gym.repository.SaleSubscriptionRepository;
import com.gym.service.SaleSubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleSubscriptionSaleImpl implements SaleSubscriptionService {

    private final SaleSubscriptionRepository saleSubscriptionRepository;

    private final ClientServiceImpl clientService;

    private final SubscriptionServiceImpl subscriptionService;

    private final SaleSubscriptionConvert saleSubscriptionConvert;

    public SaleSubscriptionSaleImpl(SaleSubscriptionRepository saleSubscriptionRepository, ClientServiceImpl clientService, SubscriptionServiceImpl subscriptionService, SaleSubscriptionConvert saleSubscriptionConvert) {
        this.saleSubscriptionRepository = saleSubscriptionRepository;
        this.clientService = clientService;
        this.subscriptionService = subscriptionService;
        this.saleSubscriptionConvert = saleSubscriptionConvert;
    }

    @Override
    public List<SaleSubscriptionDto> findByClientId(Integer id) {
        clientService.findById(id);
        return saleSubscriptionRepository.findByClientId(id)
                .stream()
                .map(saleSubscriptionConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<SaleSubscriptionDto> findBySubscriptionId(Integer id) {
        subscriptionService.findById(id);
        return saleSubscriptionRepository.findBySubscriptionId(id)
                .stream()
                .map(saleSubscriptionConvert::convert)
                .collect(Collectors.toList());
    }
}
