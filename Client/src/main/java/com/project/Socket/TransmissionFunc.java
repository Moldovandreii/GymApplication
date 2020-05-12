package com.project.Socket;

import com.project.SDProject.ClientProjectApplication;
import com.project.dao.*;

import java.util.Date;
import java.util.List;

public class TransmissionFunc {

    public static String loginFunc(String username, String password){

        Transmission.sendToServer(ClientProjectApplication.socket,  "loginFunc," + username + "," + password);
        String returned  = Transmission.receiveFromServer(ClientProjectApplication.socket);
        return returned;
    }

    public static void createTrainer(String name, String mail, String password){
        Transmission.sendToServer(ClientProjectApplication.socket, "createTrainer," + name + "," + mail + "," + password);
    }

    public static String findTrainerById(String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "findTrainerById," + id);
        String returned = Transmission.receiveFromServer(ClientProjectApplication.socket);
        return  returned;
    }

    public static void updateTrainer(String name, String mail, String password, String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "updateTrainer," + name + "," + mail + "," + password + "," + id);
    }

    public static void deleteTrainer(String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "deleteTrainer," + id);
    }

    public static String findNameById(String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "findNameById," + id);
        String returned = Transmission.receiveFromServer(ClientProjectApplication.socket);
        return returned;
    }

    public static void createFood(String name, String duration, String calories){
        Transmission.sendToServer(ClientProjectApplication.socket, "createFood," + name + "," + duration + "," + calories);
    }

    public static String findFoodById(String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "findFoodById," + id);
        String returned = Transmission.receiveFromServer(ClientProjectApplication.socket);
        return returned;
    }

    public static void updateFood(String name, String duration, String calories, String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "updateFood," + name + "," + duration + "," + calories + "," + id);
    }

    public static void deleteFood(String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "deleteFood," + id);
    }

    public static void createActivity(String name, String duration, String intensity){
        Transmission.sendToServer(ClientProjectApplication.socket, "createActivity," + name + "," + duration +"," + intensity);
    }

    public static String findActivityById(String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "findActivityById," + id);
        String returned = Transmission.receiveFromServer(ClientProjectApplication.socket);
        return  returned;
    }

    public static void updateActivity(String name, String duration, String intensity, String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "updateActivity," + name + "," + duration + "," + intensity + "," + id);
    }

    public static void deleteActivity(String id){
        Transmission.sendToServer(ClientProjectApplication.socket, "deleteActivity," + id);
    }

    public static List<TrainerDAO> getAllTrainers(){
        Transmission.sendToServer(ClientProjectApplication.socket, "getAllTrainers");
        try{
            return (List<TrainerDAO>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<FoodDAO> getAllFood(){
        Transmission.sendToServer(ClientProjectApplication.socket, "getAllFood");
        try{
            return(List<FoodDAO>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<ActivityDAO> getAllActivities(){
        Transmission.sendToServer(ClientProjectApplication.socket, "getAllActivities");
        try{
            return (List<ActivityDAO>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static void createProgram(String activityIds, String name, String trainerName, String trainerPassword){
        Transmission.sendToServer(ClientProjectApplication.socket, "createProgram," + activityIds + "," + name + "," + trainerName + "," + trainerPassword);
    }

    public static void createDiet(String foodIds, String name, String trainerName, String trainerPassword){
        Transmission.sendToServer(ClientProjectApplication.socket, "createDiet," + foodIds + "," + name + "," + trainerName + "," + trainerPassword);
    }

    public static void createClient(String name, String password, String trainerName, String trainerPassword){
        Transmission.sendToServer(ClientProjectApplication.socket, "createClient," + name + "," + password + "," + trainerName + "," + trainerPassword);
    }

    public static List<ClientDAO> getAllClients(String trainerName, String trainerPassword){
        Transmission.sendToServer(ClientProjectApplication.socket, "getAllClients," + trainerName + "," + trainerPassword);
        try{
            return (List<ClientDAO>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static Date showAttendance(String clientName, String clientPassword){
        Transmission.sendToServer(ClientProjectApplication.socket, "showAttendance," + clientName + "," + clientPassword);
        try{
            return (Date)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static List<ProgramDAO> getAllPrograms(String trainerName, String trainerPassword){
        Transmission.sendToServer(ClientProjectApplication.socket, "getAllPrograms," + trainerName + "," + trainerPassword);
        try{
            return (List<ProgramDAO>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static List<DietDAO> getAllDiets(String trainerName, String trainerPassword){
        Transmission.sendToServer(ClientProjectApplication.socket, "getAllDiets," + trainerName + "," + trainerPassword);
        try{
            return (List<DietDAO>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static List<ActivityDAO> getProgramActivities(String programId){
        Transmission.sendToServer(ClientProjectApplication.socket, "getProgramActivities," + programId);
        try{
            return (List<ActivityDAO>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static List<FoodDAO> getDietFood(String dietId){
        Transmission.sendToServer(ClientProjectApplication.socket, "getDietFood," + dietId);
        try{
            return (List<FoodDAO>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static List<String> getTrainerNamePass(String trainerId){
        Transmission.sendToServer(ClientProjectApplication.socket, "getTrainerNamePass," + trainerId);
        try{
            return (List<String>)ClientProjectApplication.objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public static void updateClientLogin(String name, String password){
        Transmission.sendToServer(ClientProjectApplication.socket, "updateClientLogin," + name + "," + password);
    }

    public static String getAttendance(String name, String password){
        Transmission.sendToServer(ClientProjectApplication.socket, "getAttendances," + name + "," + password);
        return Transmission.receiveFromServer(ClientProjectApplication.socket);
    }

}
