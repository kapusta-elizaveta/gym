package com.gym.service;

import com.gym.dto.SaleSubscriptionDto;
import com.gym.entity.SaleSubscription;

import java.util.List;

public interface SaleSubscriptionService {

    List<SaleSubscriptionDto> findByClientId(Integer id);

    List<SaleSubscriptionDto> findBySubscriptionId(Integer id);
}
