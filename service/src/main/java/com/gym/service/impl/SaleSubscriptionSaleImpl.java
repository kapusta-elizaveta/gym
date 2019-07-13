package com.gym.service.impl;

import com.gym.convertors.SaleSubscriptionConvert;
import com.gym.dto.SaleSubscriptionDto;
import com.gym.entity.SaleSubscription;
import com.gym.myException.SaleSubscriptionNotFoundException;
import com.gym.repository.SaleSubscriptionRepository;
import com.gym.service.SaleSubscriptionService;
import com.gym.validate.Validate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleSubscriptionSaleImpl implements SaleSubscriptionService {

    private final SaleSubscriptionRepository saleSubscriptionRepository;

    private final ClientServiceImpl clientService;

    private final SubscriptionServiceImpl subscriptionService;

    private final SaleSubscriptionConvert saleSubscriptionConvert;

    private final Validate validate;

    public SaleSubscriptionSaleImpl(SaleSubscriptionRepository saleSubscriptionRepository, ClientServiceImpl clientService, SubscriptionServiceImpl subscriptionService, SaleSubscriptionConvert saleSubscriptionConvert, Validate validate) {
        this.saleSubscriptionRepository = saleSubscriptionRepository;
        this.clientService = clientService;
        this.subscriptionService = subscriptionService;
        this.saleSubscriptionConvert = saleSubscriptionConvert;
        this.validate = validate;
    }

    @Override
    public List<SaleSubscription> findByClientId(Integer id) {
        clientService.findById(id);
        return saleSubscriptionRepository.findByClientId(id);
    }

    @Override
    public List<SaleSubscription> findBySubscriptionId(Integer id) {
        subscriptionService.findById(id);
        return saleSubscriptionRepository.findBySubscriptionId(id);
    }

    @Override
    public SaleSubscription save(SaleSubscriptionDto saleSubscriptionDto) {
        if (!validate.correctDate(saleSubscriptionDto.getStartDate())) throw new IllegalArgumentException("Thisis not a startDate");
        if (!validate.correctDate(saleSubscriptionDto.getEndDate())) throw new IllegalArgumentException("Thisis not a endDate");
        SaleSubscription saleSubscription = saleSubscriptionConvert.convert(saleSubscriptionDto);
        saleSubscription.setClient(clientService.findById(saleSubscriptionDto.getClientId()));
        saleSubscription.setSubscription(subscriptionService.findById(saleSubscriptionDto.getSubscriptionsId()));
        return saleSubscriptionRepository.save(saleSubscription);
    }

    @Override
    public void deleteById(Integer id) {
        this.findById(id);
        saleSubscriptionRepository.deleteById(id);
    }

    @Override
    public SaleSubscription findById(Integer id) {
        Optional<SaleSubscription> optionalSaleSubscription = saleSubscriptionRepository.findById(id);
        if (optionalSaleSubscription.isPresent()){
            return optionalSaleSubscription.get();
        } throw new SaleSubscriptionNotFoundException("No such SaleSubscription");
    }
}
