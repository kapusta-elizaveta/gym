package com.gym.repository;

import com.gym.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    @Query("select a from Subscription a where a.price < :price ")
    List<Subscription> findCheaperSubscription(@Param("price") double price);
}
