//package com.project.services;
//
//import com.project.entities.Trainer;
//import com.project.repository.TrainerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TrainerServiceImpl implements TrainerService{
//    private TrainerRepository trainerRepository;
//
//    @Autowired
//    public TrainerServiceImpl(TrainerRepository trainerRepository){
//        this.trainerRepository = trainerRepository;
//    }
//
//    @Override
//    public Trainer findById(int id) {
//        return trainerRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Trainer findByName(String username) {
//        return trainerRepository.findByUsername(username);
//    }
//
//    @Override
//    public Trainer save(String username) {
//        return trainerRepository.save(Trainer.builder().username(username).build());
//    }
//
//    public void create(String username, String mail, String password){
//        trainerRepository.save(Trainer.builder().username(username).password(password).mail(mail).build());
//    }
//
//    public void update(String username, String mail, String password, int id){
//        trainerRepository.save(Trainer.builder().trainerId(id).username(username).password(password).mail(mail).build());
//    }
//
//    public void delete(int id){
//        trainerRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Trainer> getAllTrainers() {
//        return trainerRepository.findAll();
//    }
//
//    public Trainer findByUsernameAndPassword(String username, String password){
//        return trainerRepository.findByUsernameAndPassword(username, password);
//    }
//}
