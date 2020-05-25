package com.project.services;

import com.project.dao.DietDAO;
import com.project.entities.Diet;
import com.project.entities.Food;
import com.project.entities.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DietService {
    Diet findById(int id);

    void createDiet(String name, Trainer trainer, List<Food> foods);

    List<Diet> findByTrainer(Trainer trainer);

    List<DietDAO> findByTrainerDAO(Trainer trainer);

    Diet findByDietName(String name);

    DietDAO getDietDAO(Diet diet);
}
