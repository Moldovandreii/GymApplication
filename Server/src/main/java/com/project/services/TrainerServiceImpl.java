package com.project.services;

import com.project.dao.TrainerDAO;
import com.project.entities.Trainer;
import com.project.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{
    private TrainerRepository trainerRepository;

    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Trainer findById(int id) {
        return trainerRepository.findById(id).orElse(null);
    }

    @Override
    public Trainer findByName(String username) {
        return trainerRepository.findByUsername(username);
    }

    @Override
    public Trainer save(String username) {
        return trainerRepository.save(Trainer.builder().username(username).build());
    }

    public void create(String username, String mail, String password){
        trainerRepository.save(Trainer.builder().username(username).password(password).mail(mail).build());
    }

    public void update(String username, String mail, String password, int id){
        trainerRepository.save(Trainer.builder().trainerId(id).username(username).password(password).mail(mail).build());
    }

    public void delete(int id){
        trainerRepository.deleteById(id);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer findByUsernameAndPassword(String username, String password){
        return trainerRepository.findByUsernameAndPassword(username, password);
    }

    public List<TrainerDAO> getAllTrainerDAO(){
        List<Trainer> trainers = trainerRepository.findAll();
        List<TrainerDAO> trainerDAOS = new ArrayList<TrainerDAO>();
        for(int i=0 ; i<trainers.size(); i++){
            TrainerDAO trainer = new TrainerDAO();
            trainer.setTrainerId(trainers.get(i).getTrainerId());
            trainer.setUsername(trainers.get(i).getUsername());
            trainer.setPassword(trainers.get(i).getPassword());
            trainer.setMail(trainers.get(i).getMail());
            trainer.setReview(trainers.get(i).getReview());
            trainer.setReviews(trainers.get(i).getReviews());
            trainerDAOS.add(trainer);
        }
        return trainerDAOS;
    }

    public TrainerDAO getTrainerDAO(int id){
        Trainer trainer = trainerRepository.findByTrainerId(id);
        TrainerDAO trainerDAO = new TrainerDAO();
        trainerDAO.setTrainerId(trainer.getTrainerId());
        trainerDAO.setUsername(trainer.getUsername());
        trainerDAO.setPassword(trainer.getPassword());
        trainerDAO.setMail(trainer.getMail());
        return trainerDAO;
    }

    public void updateReview(int id, float review){
        Trainer trainer = trainerRepository.findByTrainerId(id);
        trainerRepository.save(Trainer.builder().trainerId(id).username(trainer.getUsername()).password(trainer.getPassword()).mail(trainer.getMail()).reviews(trainer.getReviews()).review(review).build());
    }

    public void updateReviews(int id, int reviews){
        Trainer trainer = trainerRepository.findByTrainerId(id);
        trainerRepository.save(Trainer.builder().trainerId(id).username(trainer.getUsername()).password(trainer.getPassword()).mail(trainer.getMail()).review(trainer.getReview()).reviews(reviews).build());
    }

//    public void deleteClient(int trainerId, Client client){
//        Trainer trainer = trainerRepository.findByTrainerId(trainerId);
//        List<Client> clients = trainer.getClients();
//        List<Client> updateList = new ArrayList<Client>();
//        for(int i=0; i<clients.size(); i++){
//            if(clients.get(i).getClientId() != client.getClientId()){
//                updateList.add(clients.get(i));
//            }
//        }
//        trainerRepository.save(Trainer.builder().trainerId(trainerId).username(trainer.getUsername()).password(trainer.getPassword()).mail(trainer.getMail()).review(trainer.getReview()).reviews(trainer.getReviews()).clients(updateList).build());
//        Trainer tr = trainerRepository.findByTrainerId(trainerId);
//    }
//
//    public void addClient(int trainerId, Client client){
//        Trainer trainer = trainerRepository.findByTrainerId(trainerId);
//        List<Client> clients = trainer.getClients();
//        clients.add(client);
//        trainerRepository.save(Trainer.builder().trainerId(trainerId).username(trainer.getUsername()).password(trainer.getPassword()).mail(trainer.getMail()).review(trainer.getReview()).reviews(trainer.getReviews()).clients(clients).build());
//    }
}
