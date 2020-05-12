//package com.project.services;
//
//import com.project.entities.Food;
//import com.project.repository.FoodRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class FoodServiceImpl implements FoodService{
//    private FoodRepository foodRepository;
//
//    @Autowired
//    public FoodServiceImpl(FoodRepository foodRepository){
//        this.foodRepository = foodRepository;
//    }
//
//    @Override
//    public Food findById(int id) {
//        return foodRepository.findById(id).orElse(null);
//    }
//
//
//    public void create(String name, int duration, int calorie){
//        foodRepository.save(Food.builder().name(name).duration(duration).caloriesCount(calorie).build());
//    }
//
//    public void update(String name, int duration, int calorie, int id){
//        foodRepository.save(Food.builder().foodId(id).name(name).duration(duration).caloriesCount(calorie).build());
//    }
//
//    public void delete(int id){
//        foodRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Food> getAllFood() {
//        return foodRepository.findAll();
//    }
//}
