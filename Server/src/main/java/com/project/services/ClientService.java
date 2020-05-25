package com.project.services;

import com.project.dao.ClientDAO;
import com.project.entities.Client;
import com.project.entities.Diet;
import com.project.entities.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client findById(int id);

    void createClient(String name, String password, Trainer trainer, Diet diet);

    List<Client> findByTrainer(Trainer trainer);

    Client findByUsernameAndPassword(String name, String password);

    Client findByTrainerAndName(Trainer trainer, String name);

    void update(int id, String name, String password);

    List<ClientDAO> findByTrainerDAO(Trainer trainer);

    void changeTrainer(int id, Trainer trainer);

    void changeDiet(int id, Diet diet);
}
