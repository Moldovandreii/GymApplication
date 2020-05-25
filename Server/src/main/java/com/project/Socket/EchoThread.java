package com.project.Socket;

import com.project.services.*;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoThread extends Thread {
    public Socket socket;
    private ServiceFunctions serviceFunctions;
    private TrainerService trainerService;
    private FoodService foodService;
    private ActivityService activityService;
    private ClientService clientService;
    private ProgramService programService;
    private DietService dietService;
    private RequestService requestService;
    private RequestDietService requestDietService;

    public EchoThread(ServiceFunctions serviceFunctions, TrainerService trainerService, FoodService foodService, ActivityService activityService, ClientService clientService, ProgramService programService, DietService dietService, RequestService requestService, RequestDietService requestDietService, Socket socket){
        this.serviceFunctions = serviceFunctions;
        this.trainerService = trainerService;
        this.foodService = foodService;
        this.activityService = activityService;
        this.clientService = clientService;
        this.programService = programService;
        this.dietService = dietService;
        this.requestService = requestService;
        this.requestDietService = requestDietService;
        this.socket = socket;
    }

    public void run(){
        try{
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            //InputStream inputStream = socket.getInputStream();
            //ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            while (true){
                String received = Transmission.receiveFromClient(socket);
                String[] values = received.split(",");
                TransmissionFunc.sendBack(socket, objectOutputStream, values, serviceFunctions, trainerService, foodService, activityService, programService, dietService, clientService, requestService, requestDietService);
                }
            }catch (Exception e){
            e.printStackTrace();
        }
    }
}
