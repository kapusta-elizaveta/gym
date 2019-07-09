package com.gym.myException;

import com.gym.entity.SaleSubscription;

public class SaleSubscriptionNotFoundException extends RuntimeException  {

    public SaleSubscriptionNotFoundException(String message){ super(message);}
}
