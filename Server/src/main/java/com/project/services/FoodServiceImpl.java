package com.project.services;

import com.project.dao.FoodDAO;
import com.project.entities.Food;
import com.project.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{
    private FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    @Override
    public Food findById(int id) {
        return foodRepository.findById(id).orElse(null);
    }


    public void create(String name, int duration, int calorie){
        foodRepository.save(Food.builder().name(name).duration(duration).caloriesCount(calorie).build());
    }

    public void update(String name, int duration, int calorie, int id){
        foodRepository.save(Food.builder().foodId(id).name(name).duration(duration).caloriesCount(calorie).build());
    }

    public void delete(int id){
        foodRepository.deleteById(id);
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public List<FoodDAO> getAllFoodDAO() {
        List<Food> foods = foodRepository.findAll();
        List<FoodDAO> foodsDAO = new ArrayList<FoodDAO>();
        for(int i=0; i<foods.size(); i++){
            FoodDAO food = new FoodDAO();
            food.setFoodId(foods.get(i).getFoodId());
            food.setName(foods.get(i).getName());
            food.setDuration(foods.get(i).getDuration());
            food.setCaloriesCount(foods.get(i).getCaloriesCount());
            foodsDAO.add(food);
        }
        return foodsDAO;
    }
}
