package com.project.services;


import com.project.dao.RequestDAO;
import com.project.entities.Request;
import com.project.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    private RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    @Override
    public Request findById(int id) {
        return requestRepository.findByRequestId(id);
    }

    @Override
    public void createRequest(int clientId, int fromTrainer, int toTrainer) {
        requestRepository.save(Request.builder().clientId(clientId).fromTrainer(fromTrainer).toTrainer(toTrainer).fromTrainerResponse("pending").toTrainerResponse("pending").requestResponse("pending").build());
    }

    @Override
    public List<Request> getRequestsToChangeFrom(int fromTrainer) {
        return requestRepository.findByFromTrainerAndFromTrainerResponse(fromTrainer, "pending");
    }

    @Override
    public List<Request> getRequestsToChangeTo(int toTrainer) {
        List<Request> requests = new ArrayList<Request>();
        List<Request> req1 = requestRepository.findByToTrainerAndToTrainerResponseAndFromTrainerResponse(toTrainer, "pending", "accept");
        List<Request> req2 = requestRepository.findByToTrainerAndToTrainerResponseAndFromTrainerResponse(toTrainer, "pending", "deny");
        requests.addAll(req1);
        requests.addAll(req2);
        return requests;
    }

    @Override
    public RequestDAO getRequestDAO(Request request) {
        RequestDAO requestDAO = new RequestDAO();
        requestDAO.setRequestId(request.getRequestId());
        requestDAO.setClientId(request.getClientId());
        requestDAO.setFromTrainer(request.getFromTrainer());
        requestDAO.setToTrainer(request.getToTrainer());
        requestDAO.setFromTrainerResponse(request.getFromTrainerResponse());
        requestDAO.setToTrainerResponse(request.getToTrainerResponse());
        requestDAO.setRequestResponse(request.getRequestResponse());
        return requestDAO;
    }

    @Override
    public void updateFromTrainerStatus(Request request, String status) {
        requestRepository.save(Request.builder().requestId(request.getRequestId()).clientId(request.getClientId()).fromTrainer(request.getFromTrainer()).toTrainer(request.getToTrainer()).fromTrainerResponse(status).toTrainerResponse(request.getToTrainerResponse()).requestResponse(request.getRequestResponse()).build());
    }

    @Override
    public void updateToTrainerStatus(Request request, String status) {
        requestRepository.save(Request.builder().requestId(request.getRequestId()).clientId(request.getClientId()).fromTrainer(request.getFromTrainer()).toTrainer(request.getToTrainer()).fromTrainerResponse(request.getFromTrainerResponse()).toTrainerResponse(status).requestResponse(request.getRequestResponse()).build());
    }

    @Override
    public void updateResultStatus(Request request, String status) {
        requestRepository.save(Request.builder().requestId(request.getRequestId()).clientId(request.getClientId()).fromTrainer(request.getFromTrainer()).toTrainer(request.getToTrainer()).fromTrainerResponse(request.getFromTrainerResponse()).toTrainerResponse(request.getToTrainerResponse()).requestResponse(status).build());
    }
}
