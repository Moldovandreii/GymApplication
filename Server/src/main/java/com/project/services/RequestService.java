package com.project.services;

import com.project.dao.RequestDAO;
import com.project.entities.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {
    Request findById(int id);

    void createRequest(int clientId, int fromTrainer, int toTrainer);

    List<Request> getRequestsToChangeFrom(int fromTrainer);

    List<Request> getRequestsToChangeTo(int toTrainer);

    RequestDAO getRequestDAO(Request request);

    void updateFromTrainerStatus(Request request, String status);

    void updateToTrainerStatus(Request request, String status);

    void updateResultStatus(Request request, String status);
}
