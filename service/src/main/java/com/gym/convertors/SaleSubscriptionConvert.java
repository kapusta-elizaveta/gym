package com.gym.convertors;

import com.gym.dto.SaleSubscriptionDto;
import com.gym.entity.SaleSubscription;
import org.springframework.stereotype.Component;

@Component
public class SaleSubscriptionConvert {

    public SaleSubscriptionDto convert(SaleSubscription saleSubscription){
        SaleSubscriptionDto saleSubscriptionDto = new SaleSubscriptionDto();
        saleSubscriptionDto.setId(saleSubscription.getId());
        saleSubscriptionDto.setStartDate(saleSubscription.getStartDate());
        saleSubscription.setEndDate(saleSubscription.getEndDate());
        return saleSubscriptionDto;
    }

    public SaleSubscription convert(SaleSubscriptionDto saleSubscriptionDto){
        SaleSubscription saleSubscription = new SaleSubscription();
        saleSubscription.setId(saleSubscriptionDto.getId());
        saleSubscription.setStartDate(saleSubscriptionDto.getStartDate());
        saleSubscription.setEndDate(saleSubscriptionDto.getEndDate());
        return saleSubscription;
    }
}
