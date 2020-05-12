package com.project.services;

import com.project.dao.FoodDAO;
import com.project.entities.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    Food findById(int id);

    List<Food> getAllFood();

    void create(String name, int duration, int calorie);

    void update(String name, int duration, int calorie, int id);

    void delete(int id);

    List<FoodDAO> getAllFoodDAO();
}
