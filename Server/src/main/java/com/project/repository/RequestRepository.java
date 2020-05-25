package com.project.repository;

import com.project.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    Request findByRequestId(int id);

    List<Request> findByFromTrainerAndFromTrainerResponse(int fromTrainer, String fromTrainerResponse);

    List<Request> findByToTrainerAndToTrainerResponseAndFromTrainerResponse(int toTrainer, String toTrainerResponse, String fromTrainerResponse);
}
