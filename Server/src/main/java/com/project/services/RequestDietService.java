package com.project.services;

import com.project.dao.RequestDietDAO;
import com.project.entities.RequestDiet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestDietService {
    RequestDiet findById(int id);

    void createRequest(int clientId, int trainerId, String request);

    List<RequestDiet> getRequestsFromTrainer(int trainerId);

    RequestDietDAO getRequestDietDAO(RequestDiet requestDiet);

    void changeStatus(RequestDiet requestDiet, String status);

    RequestDiet getRequestByClient(int clientId);
}
