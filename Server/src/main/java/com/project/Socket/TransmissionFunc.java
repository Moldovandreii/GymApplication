package com.project.Socket;

import com.project.dao.*;
import com.project.entities.*;
import com.project.services.*;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransmissionFunc {

    public static void sendBack(Socket socket, ObjectOutputStream objectOutputStream, String[] values, ServiceFunctions serviceFunctions, TrainerService trainerService, FoodService foodService, ActivityService activityService, ProgramService programService, DietService dietService, ClientService clientService, RequestService requestService, RequestDietService requestDietService){
        if(values[0].equals("loginFunc")){
            String username = values[1];
            String password = values[2];
           if(serviceFunctions.adminOrTrainerOrClient(username, password).equals("Admin")){
               Transmission.sendToClient(socket, "Admin");
           }else if(serviceFunctions.adminOrTrainerOrClient(username, password).equals("Trainer")) {
               Transmission.sendToClient(socket, "Trainer");
           }else if(serviceFunctions.adminOrTrainerOrClient(username, password).equals("Client")){
               Transmission.sendToClient(socket, "Client");
           } else{
               Transmission.sendToClient(socket, "Invalid");
           }
       }
       else if(values[0].equals("createTrainer")){
           String name = values[1];
           String mail = values[2];
           String password = values[3];
           trainerService.create(name, mail, password);
       }
       else if(values[0].equals("findTrainerById")){
           int id = Integer.parseInt(values[1]);
           if(trainerService.findById(id) != null){
               Transmission.sendToClient(socket, "exists");
           }else{
               Transmission.sendToClient(socket, "dontExist");
           }
        }
       else if(values[0].equals("updateTrainer")){
           String name = values[1];
           String mail = values[2];
           String password = values[3];
           int id = Integer.parseInt(values[4]);
           trainerService.update(name, mail, password, id);
        }
       else if(values[0].equals("deleteTrainer")){
           int id = Integer.parseInt(values[1]);
           trainerService.delete(id);
        }
       else if(values[0].equals("findNameById")){
            int id = Integer.parseInt(values[1]);
            Trainer tr = trainerService.findById(id);
            Transmission.sendToClient(socket, tr.getUsername());
        }
       else if(values[0].equals("createFood")){
           String name = values[1];
           int duration = Integer.parseInt(values[2]);
           int calories = Integer.parseInt(values[3]);
           foodService.create(name, duration, calories);
        }
       else if(values[0].equals("findFoodById")){
            int id = Integer.parseInt(values[1]);
            if(foodService.findById(id) != null){
                Transmission.sendToClient(socket, "exists");
            }else{
                Transmission.sendToClient(socket, "dontExist");
            }
        }
       else if(values[0].equals("updateFood")){
            String name = values[1];
            int duration = Integer.parseInt(values[2]);
            int calories = Integer.parseInt(values[3]);
            int id = Integer.parseInt(values[4]);
            foodService.update(name, duration, calories, id);
        }
       else if(values[0].equals("deleteFood")){
            int id = Integer.parseInt(values[1]);
            foodService.delete(id);
        }
       else if(values[0].equals("createActivity")){
           String name = values[1];
           int duration = Integer.parseInt(values[2]);
           int intensity = Integer.parseInt(values[3]);
           activityService.create(name, duration, intensity);
        }
       else if(values[0].equals("findActivityById")){
            int id = Integer.parseInt(values[1]);
            if(activityService.findById(id) != null){
                Transmission.sendToClient(socket, "exists");
            }else{
                Transmission.sendToClient(socket, "exists");
            }
        }
       else if(values[0].equals("updateActivity")){
            String name = values[1];
            int duration = Integer.parseInt(values[2]);
            int intensity = Integer.parseInt(values[3]);
            int id = Integer.parseInt(values[4]);
            activityService.update(name, duration, intensity, id);
        }
       else if(values[0].equals("deleteActivity")){
            int id = Integer.parseInt(values[1]);
            activityService.delete(id);
        }
       else if(values[0].equals("getAllTrainers")){
            List<TrainerDAO> trainers = trainerService.getAllTrainerDAO();
            try{
                objectOutputStream.writeObject(trainers);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
       else if(values[0].equals("getAllFood")){
           List<FoodDAO> food = foodService.getAllFoodDAO();
           try{
               objectOutputStream.writeObject(food);
           }catch (Exception e){
               e.printStackTrace();
           }
        }
       else if(values[0].equals("getAllActivities")){
           List<ActivityDAO> activities = activityService.getAllActivitiesDAO();
           try{
               objectOutputStream.writeObject(activities);
           }catch (Exception e){
               e.printStackTrace();
           }
        }
       else if(values[0].equals("createProgram")){
           String activityIds = values[1];
           String programName = values[2];
           String trainerName = values[3];
           String trainerPassword = values[4];
            List<Activity> activities = new ArrayList<Activity>();
            for(int i=0; i<activityIds.length(); i++){
                if(activityIds.charAt(i) != '+'){
                    int id = Integer.parseInt(String.valueOf(activityIds.charAt(i)));
                    Activity activity = activityService.findById(id);
                    activities.add(activity);
                }
            }
            Trainer trainer = trainerService.findByUsernameAndPassword(trainerName, trainerPassword);
            programService.createProgram(programName, trainer, activities);
        }
       else if(values[0].equals("createDiet")){
            String foodIds = values[1];
            String dietName = values[2];
            String trainerName = values[3];
            String trainerPassword = values[4];
            List<Food> foods = new ArrayList<Food>();
            for(int i=0; i<foodIds.length(); i++){
                if(foodIds.charAt(i) != '+'){
                    int id = Integer.parseInt(String.valueOf(foodIds.charAt(i)));
                    Food food = foodService.findById(id);
                    foods.add(food);
                }
            }
            Trainer trainer = trainerService.findByUsernameAndPassword(trainerName, trainerPassword);
            dietService.createDiet(dietName, trainer, foods);
        }
       else if(values[0].equals("createClient")){
            String name = values[1];
            String password = values[2];
            String trainerName = values[3];
            String trainerPassword = values[4];
            Trainer trainer = trainerService.findByUsernameAndPassword(trainerName, trainerPassword);
            Diet diet = dietService.findById(1);
            clientService.createClient(name, password, trainer, diet);
        }
        else if(values[0].equals("getAllClients")){
            String name = values[1];
            String password = values[2];
            Trainer trainer = trainerService.findByUsernameAndPassword(name, password);
            List<ClientDAO> clients = clientService.findByTrainerDAO(trainer);
            try{
                objectOutputStream.writeObject(clients);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("getAllPrograms")){
            String name = values[1];
            String password = values[2];
            Trainer trainer = trainerService.findByUsernameAndPassword(name, password);
            List<ProgramDAO> programs = programService.findByTrainerDAO(trainer);
            try{
                objectOutputStream.writeObject(programs);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("getAllDiets")){
            String name = values[1];
            String password = values[2];
            Trainer trainer = trainerService.findByUsernameAndPassword(name, password);
            List<DietDAO> diets = dietService.findByTrainerDAO(trainer);
            try{
                objectOutputStream.writeObject(diets);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("getProgramActivities")){
            int programId = Integer.parseInt(values[1]);
            Program program = programService.findById(programId);
            List<Activity> activities = program.getActivities();
            List<ActivityDAO> activityDAOS = new ArrayList<ActivityDAO>();
            for(int i=0; i<activities.size(); i++){
                ActivityDAO activity = new ActivityDAO();
                activity.setActivityId(activities.get(i).getActivityId());
                activity.setName(activities.get(i).getName());
                activity.setDuration(activities.get(i).getDuration());
                activity.setIntensity(activities.get(i).getIntensity());
                activityDAOS.add(activity);
            }
            try{
                objectOutputStream.writeObject(activityDAOS);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("getDietFood")){
            int dietId = Integer.parseInt(values[1]);
            Diet diet = dietService.findById(dietId);
            List<Food> foods = diet.getFoods();
            List<FoodDAO> foodDAOS = new ArrayList<FoodDAO>();
            for(int i=0; i<foods.size(); i++){
                FoodDAO food = new FoodDAO();
                food.setFoodId(foods.get(i).getFoodId());
                food.setName(foods.get(i).getName());
                food.setDuration(foods.get(i).getDuration());
                food.setCaloriesCount(foods.get(i).getCaloriesCount());
                foodDAOS.add(food);
            }
            try{
                objectOutputStream.writeObject(foodDAOS);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("showAttendance")){
            String name = values[1];
            String password = values[2];
            Client client = clientService.findByUsernameAndPassword(name, password);
            Date date = client.getAttendanceDate().getLastLogin();
            try{
                objectOutputStream.writeObject(date);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("getTrainerNamePass")){
            int trainerId = Integer.parseInt(values[1]);
            Trainer trainer = trainerService.findById(trainerId);
            String name = trainer.getUsername();
            String password = trainer.getPassword();
            List<String> ret = new ArrayList<String>();
            ret.add(name);
            ret.add(password);
            try{
                objectOutputStream.writeObject(ret);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("updateClientLogin")){
            String name = values[1];
            String password = values[2];
            Client client = clientService.findByUsernameAndPassword(name, password);
            int clientId = client.getClientId();
            clientService.update(clientId, name, password);
        }
        else if(values[0].equals("getAttendances")){
            String name = values[1];
            String password = values[2];
            Client client = clientService.findByUsernameAndPassword(name, password);
            int attendance = client.getAttendanceDate().getAttendance();
            String ret = Integer.toString(attendance);
            Transmission.sendToClient(socket, ret);
        }
        else if(values[0].equals("findTrainerByClient")){
            String name = values[1];
            String password = values[2];
            Client client = clientService.findByUsernameAndPassword(name, password);
            Trainer trainer = client.getTrainer();
            TrainerDAO trainerDAO = trainerService.getTrainerDAO(trainer.getTrainerId());
            try{
                objectOutputStream.writeObject(trainerDAO);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("rateTrainer")){
            float rate = Integer.parseInt(values[1]);
            int trainerId = Integer.parseInt(values[2]);
            Trainer trainer = trainerService.findById(trainerId);

            if(trainer.getReviews() == 0){
                trainerService.updateReview(trainerId, rate);
                trainerService.updateReviews(trainerId, 1);
            }else{
                float newReview = (trainer.getReview() * trainer.getReviews() + rate) / (trainer.getReviews() + 1);
                trainerService.updateReview(trainerId, newReview);
                trainerService.updateReviews(trainerId, trainer.getReviews() + 1);
            }
        }
        else if(values[0].equals("requestChange")){
            int currentTrainer = Integer.parseInt(values[1]);
            int changeTrainer = Integer.parseInt(values[2]);
            String clientName = values[3];
            String clientPass = values[4];
            Client client = clientService.findByUsernameAndPassword(clientName, clientPass);
            int clientId = client.getClientId();
            requestService.createRequest(clientId, currentTrainer, changeTrainer);
        }
        else if(values[0].equals("findTrainerByNameAndPass")){
            String name = values[1];
            String pass = values[2];
            Trainer trainer = trainerService.findByUsernameAndPassword(name, pass);
            Transmission.sendToClient(socket, Integer.toString(trainer.getTrainerId()));
        }
        else if(values[0].equals("findClientByNameAndPass")){
            String name = values[1];
            String pass = values[2];
            Client client = clientService.findByUsernameAndPassword(name, pass);
            Transmission.sendToClient(socket, Integer.toString(client.getClientId()));
        }
        else if(values[0].equals("findRequestToChange")){
            int trainerId = Integer.parseInt(values[1]);
            List<Request> requests = requestService.getRequestsToChangeFrom(trainerId);
            RequestDAO request;
            if(requests.size() != 0){
               request = requestService.getRequestDAO(requests.get(0));
            }
            else{
                request = null;
            }
            try{
                objectOutputStream.writeObject(request);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("findRequestToAccept")){
            int trainerId = Integer.parseInt(values[1]);
            List<Request> requests = requestService.getRequestsToChangeTo(trainerId);
            RequestDAO request;
            if(requests.size() != 0){
                request = requestService.getRequestDAO(requests.get(0));
            }
            else{
                request = null;
            }
            try{
                objectOutputStream.writeObject(request);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("findDietRequest")){
            int trainerId = Integer.parseInt(values[1]);
            List<RequestDiet> requests = requestDietService.getRequestsFromTrainer(trainerId);
            RequestDietDAO request;
            if(requests.size() != 0){
                request = requestDietService.getRequestDietDAO(requests.get(0));
            }
            else{
                request = null;
            }
            try{
                objectOutputStream.writeObject(request);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(values[0].equals("setFromTrainerStat")){
            int requestId = Integer.parseInt(values[1]);
            String status = values[2];
            Request request = requestService.findById(requestId);
            requestService.updateFromTrainerStatus(request, status);
        }
        else if(values[0].equals("setToTrainerStat")){
            int requestId = Integer.parseInt(values[1]);
            String status = values[2];
            Request request = requestService.findById(requestId);
            Client client = clientService.findById(request.getClientId());
            requestService.updateToTrainerStatus(request, status);
            Request newRequest = requestService.findById(requestId);
            String statusFrom = newRequest.getFromTrainerResponse();
            String statusTo = newRequest.getToTrainerResponse();
            Trainer trainer = trainerService.findById(newRequest.getToTrainer());
            if(statusFrom.equals("deny") || statusTo.equals("deny")){
                requestService.updateResultStatus(newRequest, "denied");
            }else if(statusFrom.equals("accept") && statusTo.equals("accept")){
                requestService.updateResultStatus(newRequest, "accepted");
//                trainerService.deleteClient(newRequest.getFromTrainer(), client);
//                trainerService.addClient(newRequest.getToTrainer(), client);
                clientService.changeTrainer(client.getClientId(), trainer);
            }
        }
        else if(values[0].equals("sendDietRequest")){
            int clientId = Integer.parseInt(values[1]);
            String request = values[2];
            Client client = clientService.findById(clientId);
            Trainer trainer = client.getTrainer();
            int trainerId = trainer.getTrainerId();
            requestDietService.createRequest(clientId, trainerId, request);
        }
        else if(values[0].equals("changeDiet")){
            int clientId = Integer.parseInt(values[1]);
            String dietName = values[2];
            Diet diet = dietService.findByDietName(dietName);
            clientService.changeDiet(clientId, diet);
            RequestDiet request = requestDietService.getRequestByClient(clientId);
            requestDietService.changeStatus(request, "done");
        }
        else if(values[0].equals("getClientsDiet")){
            int clientId = Integer.parseInt(values[1]);
            Client client = clientService.findById(clientId);
            Diet diet = client.getDiet();
            DietDAO dietDAO = dietService.getDietDAO(diet);
            try{
                objectOutputStream.writeObject(dietDAO);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
