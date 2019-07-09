package com.gym.repository;

import com.gym.entity.SaleSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleSubscriptionRepository extends JpaRepository<SaleSubscription, Integer> {

    List<SaleSubscription> findByClientId(Integer id);

    List<SaleSubscription> findBySubscriptionId(Integer id);
}
