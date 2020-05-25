package com.project.controller;

import com.project.Socket.EchoThread;
import com.project.services.*;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
@FxmlView("serverUI.fxml")
public class ServerController {
    public static Socket socket;
    private ServiceFunctions serviceFunctions;
    private TrainerService trainerService;
    private FoodService foodService;
    private ActivityService activityService;
    private ClientService clientService;
    private ProgramService programService;
    private DietService dietService;
    private RequestService requestService;
    private RequestDietService requestDietService;
    private int running = 0;

    @Autowired
    public ServerController(ServiceFunctions serviceFunctions, TrainerService trainerService, FoodService foodService, ActivityService activityService, ClientService clientService, ProgramService programService, DietService dietService, RequestService requestService, RequestDietService requestDietService){
        this.serviceFunctions = serviceFunctions;
        this.trainerService = trainerService;
        this.foodService = foodService;
        this.activityService = activityService;
        this.clientService = clientService;
        this.programService = programService;
        this.dietService = dietService;
        this.requestService = requestService;
        this.requestDietService = requestDietService;
    }

//    public void startServer() throws IOException {
//        running = 1;
//        ServerSocket ss = new ServerSocket(6666);
//        socket = ss.accept();
//        OutputStream outputStream = socket.getOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        //InputStream inputStream = socket.getInputStream();
//        //ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//        while (running == 1) {
//            String received = Transmission.receiveFromClient(socket);
//            String[] values = received.split(",");
//            TransmissionFunc.sendBack(socket, objectOutputStream, values, serviceFunctions, trainerService, foodService, activityService, programService, dietService, clientService);
//        }
//    }

        public void startServer() throws IOException {
            running = 1;
            ServerSocket ss = new ServerSocket(6666);
            while (running == 1) {
                socket = ss.accept();
                new EchoThread(serviceFunctions, trainerService, foodService, activityService, clientService, programService, dietService, requestService, requestDietService, socket).start();
            }
        }

        public void stopServer(){
            running = 0;
        }
//        String received = Transmission.receiveFromClient(socket);
//        String[] values = received.split(",");
//        Transmission.sendToClient(socket, "bai clientule cf");
//        System.out.println(Transmission.receiveFromClient(socket));
//
//        TransmissionFunc.sendBack(socket, values, serviceFunctions);
}
