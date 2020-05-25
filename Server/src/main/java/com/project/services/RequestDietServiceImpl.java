package com.project.services;

import com.project.dao.RequestDietDAO;
import com.project.entities.RequestDiet;
import com.project.repository.RequestDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDietServiceImpl implements RequestDietService{
    private RequestDietRepository requestDietRepository;

    @Autowired
    public RequestDietServiceImpl(RequestDietRepository requestDietRepository){
        this.requestDietRepository = requestDietRepository;
    }

    @Override
    public RequestDiet findById(int id) {
        return requestDietRepository.findByRequestDietId(id);
    }

    @Override
    public void createRequest(int clientId, int trainerId, String request) {
        requestDietRepository.save(RequestDiet.builder().clientId(clientId).trainerId(trainerId).request(request).status("pending").build());
    }

    @Override
    public List<RequestDiet> getRequestsFromTrainer(int trainerId) {
        return requestDietRepository.findByTrainerIdAndStatus(trainerId, "pending");
    }

    @Override
    public RequestDietDAO getRequestDietDAO(RequestDiet requestDiet) {
        RequestDietDAO request = new RequestDietDAO();
        request.setRequestDietId(requestDiet.getRequestDietId());
        request.setClientId(requestDiet.getClientId());
        request.setTrainerId(requestDiet.getTrainerId());
        request.setRequest(requestDiet.getRequest());
        return request;
    }

    public void changeStatus(RequestDiet requestDiet, String status){
        requestDietRepository.save(RequestDiet.builder().requestDietId(requestDiet.getRequestDietId()).clientId(requestDiet.getClientId()).trainerId(requestDiet.getTrainerId()).request(requestDiet.getRequest()).status(status).build());
    }

    public RequestDiet getRequestByClient(int clientId){
        return requestDietRepository.findByClientIdAndStatus(clientId, "pending");
    }
}
