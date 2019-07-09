package com.gym.repository;

import com.gym.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {

    List<Coach> findByName(String name);

    void deleteById(Integer id);



}
