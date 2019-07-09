package com.gym.repository;

import com.gym.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {

    List<Office> findByCoachId(Integer id);

    List<Office> findByName(String name);
}
