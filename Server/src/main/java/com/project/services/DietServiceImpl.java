package com.project.services;

import com.project.dao.DietDAO;
import com.project.entities.Diet;
import com.project.entities.Food;
import com.project.entities.Trainer;
import com.project.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DietServiceImpl implements DietService{
    private DietRepository dietRepository;

    @Autowired
    public DietServiceImpl(DietRepository dietRepository){
        this.dietRepository = dietRepository;
    }

    @Override
    public Diet findById(int id) {
        return dietRepository.findById(id).orElse(null);
    }

    @Override
    public void createDiet(String name, Trainer trainer, List<Food> foods) {
        dietRepository.save(Diet.builder().dietName(name).trainer(trainer).foods(foods).build());
    }

    @Override
    public List<Diet> findByTrainer(Trainer trainer){
        return dietRepository.findByTrainer(trainer);
    }

    public List<DietDAO> findByTrainerDAO(Trainer trainer){
        List<Diet> diets = dietRepository.findByTrainer(trainer);
        List<DietDAO> dietDAOS = new ArrayList<DietDAO>();
        for(int i=0; i<diets.size(); i++){
            DietDAO diet = new DietDAO();
            diet.setDietId(diets.get(i).getDietId());
            diet.setDietName(diets.get(i).getDietName());
            diet.setTrainerId(diets.get(i).getTrainer().getTrainerId());
            dietDAOS.add(diet);
        }
        return dietDAOS;
    }

    public Diet findByDietName(String name){
        return dietRepository.findByDietName(name);
    }

    public DietDAO getDietDAO(Diet diet){
        DietDAO dietDAO = new DietDAO();
        dietDAO.setDietId(diet.getDietId());
        dietDAO.setTrainerId(diet.getTrainer().getTrainerId());
        dietDAO.setDietName(diet.getDietName());
        List<String> foodsStr = new ArrayList<String>();
        List<Food> foods = diet.getFoods();
        for(int i=0; i<foods.size(); i++){
            foodsStr.add(foods.get(i).getName());
        }
        dietDAO.setFoods(foodsStr);
        return dietDAO;
    }
}
