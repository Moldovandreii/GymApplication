//package com.project.services;
//
//import com.project.entities.Diet;
//import com.project.entities.Food;
//import com.project.entities.Trainer;
//import com.project.repository.DietRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DietServiceImpl implements DietService{
//    private DietRepository dietRepository;
//
//    @Autowired
//    public DietServiceImpl(DietRepository dietRepository){
//        this.dietRepository = dietRepository;
//    }
//
//    @Override
//    public Diet findById(int id) {
//        return dietRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void createDiet(String name, Trainer trainer, List<Food> foods) {
//        dietRepository.save(Diet.builder().dietName(name).trainer(trainer).foods(foods).build());
//    }
//
//    @Override
//    public List<Diet> findByTrainer(Trainer trainer){
//        return dietRepository.findByTrainer(trainer);
//    }
//}
