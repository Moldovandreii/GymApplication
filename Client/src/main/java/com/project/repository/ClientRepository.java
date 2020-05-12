//package com.project.repository;
//
//import com.project.entities.Client;
//import com.project.entities.Trainer;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ClientRepository extends JpaRepository<Client, Integer> {
//    List<Client> findByTrainer(Trainer trainer);
//
//    Client findByNameAndPassword(String name, String password);
//
//    Client findByTrainerAndName(Trainer trainer, String name);
//}
