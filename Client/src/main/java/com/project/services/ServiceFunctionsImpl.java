//package com.project.services;
//
//import com.project.entities.Client;
//import com.project.entities.Trainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ServiceFunctionsImpl implements ServiceFunctions{
//    private AdminService adminService;
//    private TrainerService trainerService;
//    private ClientService clientService;
//
//    @Autowired
//    public ServiceFunctionsImpl(AdminService adminService, TrainerService trainerService, ClientService clientService){
//        this.adminService = adminService;
//        this.trainerService = trainerService;
//        this.clientService = clientService;
//    }
//
//    @Override
//    public String adminOrTrainerOrClient(String username, String password) {
//        if(adminService.findByName(username) != null && adminService.findByName(username).getPassword().equals(password)){
//            return "Admin";
//        }
//        else if(trainerService.findByName(username) != null && trainerService.findByName(username).getPassword().equals(password)){
//            return "User";
//        }
//        else if(clientService.findByUsernameAndPassword(username, password) != null){
//            return "Client";
//        }
//        else{
//            return "None";
//        }
//    }
//
//    public Trainer getTrainer(String username, String password){
//        return trainerService.findByUsernameAndPassword(username, password);
//    }
//
//    @Override
//    public Client getClient(String username, String password) {
//        return clientService.findByUsernameAndPassword(username, password);
//    }
//}
