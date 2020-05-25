package com.project.repository;

import com.project.entities.RequestDiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestDietRepository extends JpaRepository<RequestDiet, Integer> {
    RequestDiet findByRequestDietId(int id);

    List<RequestDiet> findByTrainerIdAndStatus(int id, String status);

    RequestDiet findByClientIdAndStatus(int id, String status);
}
