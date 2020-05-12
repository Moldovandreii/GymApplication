package com.project.services;

import com.project.dao.TrainerDAO;
import com.project.entities.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerService {
    Trainer findById(int id);

    Trainer findByName(String username);

    Trainer save(String username);

    List<Trainer> getAllTrainers();

    void create(String name, String mail, String password);

    void update(String name, String mail, String password, int id);

    void delete(int id);

    Trainer findByUsernameAndPassword(String username, String password);

    List<TrainerDAO> getAllTrainerDAO();
}
