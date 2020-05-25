package com.project.controller;

import com.project.ObserverDP.Observer;
import com.project.Socket.TransmissionFunc;
import com.project.dao.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("trainer.fxml")
public class TrainerController extends Observer implements Initializable{
    @FXML
    public TextField programName;
    @FXML
    public TextField programActivities;
    @FXML
    public Button createProgram;
    @FXML
    public TableView<ActivityDAO> Activities;
    @FXML
    public TableColumn<ActivityDAO, Integer> activityIdT;
    @FXML
    public TableColumn<ActivityDAO, String> activityNameT;
    @FXML
    public TableColumn<ActivityDAO, Integer> activityDurationT;
    @FXML
    public TableColumn<ActivityDAO, Integer> activityIntensityT;

    @FXML
    public TextField dietName;
    @FXML
    public TextField dietFoods;
    @FXML
    public Button createDiet;
    @FXML
    public TableView<FoodDAO> Foods;
    @FXML
    public TableColumn<FoodDAO, Integer> foodIdT;
    @FXML
    public TableColumn<FoodDAO, String> foodNameT;
    @FXML
    public TableColumn<FoodDAO, Integer> foodDurationT;
    @FXML
    public TableColumn<FoodDAO, Integer> foodCaloriesT;

    @FXML
    public TextField clientName;
    @FXML
    public TextField clientPassword;
    @FXML
    public Button createClient;
    @FXML
    public Button updateClient;
    @FXML
    public TableView<ClientDAO> Clients;
    @FXML
    public TableColumn<ClientDAO, Integer> clientIdT;
    @FXML
    public TableColumn<ClientDAO, String> clientNameT;
    @FXML
    public TableColumn<ClientDAO, String> clientPasswordT;
    @FXML
    public TableColumn<ClientDAO, Integer> clientAttendanceT;

    @FXML
    public TextArea notifyTextT;
    @FXML
    public Label requestText;
    @FXML
    public TextField dietTxt;


//    private ProgramService programService;
//    private ActivityService activityService;
//    private DietService dietService;
//    private FoodService foodService;
//    private ClientService clientService;
//    public TrainerController(ProgramService programService, ActivityService activityService, DietService dietService, FoodService foodService, ClientService clientService){
//        this.programService = programService;
//        this.activityService = activityService;
//        this.dietService = dietService;
//        this.foodService = foodService;
//        this.clientService = clientService;
//        this.subject = LoginController.subject;
//        this.subject.attach(this);
//    }

    public void createProgram(){
        String activityIds = programActivities.getText();
        TransmissionFunc.createProgram(activityIds, programName.getText(), LoginController.usernameLoging, LoginController.passwordLogin);
    }

    public void createDiet(){
        String foodIds = dietFoods.getText();
        TransmissionFunc.createDiet(foodIds, dietName.getText(), LoginController.usernameLoging, LoginController.passwordLogin);
    }

    public void createClient(){
        TransmissionFunc.createClient(clientName.getText(), clientPassword.getText(), LoginController.usernameLoging, LoginController.passwordLogin);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        activityIdT.setCellValueFactory(new PropertyValueFactory<ActivityDAO, Integer>("activityId"));
        activityNameT.setCellValueFactory(new PropertyValueFactory<ActivityDAO, String>("name"));
        activityDurationT.setCellValueFactory((new PropertyValueFactory<ActivityDAO, Integer>("duration")));
        activityIntensityT.setCellValueFactory((new PropertyValueFactory<ActivityDAO, Integer>("intensity")));
        //Activities.getItems().setAll(activityService.getAllActivities());
        Activities.getItems().setAll(TransmissionFunc.getAllActivities());

        foodIdT.setCellValueFactory(new PropertyValueFactory<FoodDAO, Integer>("foodId"));
        foodNameT.setCellValueFactory(new PropertyValueFactory<FoodDAO, String>("name"));
        foodDurationT.setCellValueFactory((new PropertyValueFactory<FoodDAO, Integer>("duration")));
        foodCaloriesT.setCellValueFactory((new PropertyValueFactory<FoodDAO, Integer>("caloriesCount")));
        //Foods.getItems().setAll(foodService.getAllFood());
        Foods.getItems().setAll(TransmissionFunc.getAllFood());

        clientIdT.setCellValueFactory(new PropertyValueFactory<ClientDAO, Integer>("clientId"));
        clientNameT.setCellValueFactory(new PropertyValueFactory<ClientDAO, String>("name"));
        clientPasswordT.setCellValueFactory(new PropertyValueFactory<ClientDAO, String>("password"));
        clientAttendanceT.setCellValueFactory(new PropertyValueFactory<ClientDAO, Integer>("attendance"));
        //Clients.getItems().setAll(clientService.findByTrainer(LoginController.trainerLogin));
        Clients.getItems().setAll(TransmissionFunc.getAllClients(LoginController.usernameLoging, LoginController.passwordLogin));
    }

    public void updateClient(){
        clientIdT.setCellValueFactory(new PropertyValueFactory<ClientDAO, Integer>("clientId"));
        clientNameT.setCellValueFactory(new PropertyValueFactory<ClientDAO, String>("name"));
        clientPasswordT.setCellValueFactory(new PropertyValueFactory<ClientDAO, String>("password"));
        clientAttendanceT.setCellValueFactory(new PropertyValueFactory<ClientDAO, Integer>("attendance"));
        //Clients.getItems().setAll(clientService.findByTrainer(LoginController.trainerLogin));
        Clients.getItems().setAll(TransmissionFunc.getAllClients(LoginController.usernameLoging, LoginController.passwordLogin));
    }


    public void readRequest(){
        String trainerId = TransmissionFunc.findTrainerByNameAndPass(LoginController.usernameLoging, LoginController.passwordLogin);
        RequestDAO changeRequest = TransmissionFunc.findRequestToChange(trainerId);
        RequestDAO acceptRequest = TransmissionFunc.findRequestToAccept(trainerId);
        RequestDietDAO requestDiet = TransmissionFunc.findDietRequest(trainerId);
        if(changeRequest != null){
            requestText.setText("Change client " + changeRequest.getClientId() + " to trainer " + changeRequest.getToTrainer() + ", req id =" + changeRequest.getRequestId());
            notifyTextT.appendText("Change client " + changeRequest.getClientId() + " to trainer " + changeRequest.getToTrainer() + ", req id =" + changeRequest.getRequestId() + "\n");
        }else if(acceptRequest != null){
            requestText.setText("Accept client " + acceptRequest.getClientId() + " from Trainer " + acceptRequest.getFromTrainer() + ", req id =" + acceptRequest.getRequestId());
            notifyTextT.appendText("Accept client " + acceptRequest.getClientId() + " from Trainer " + acceptRequest.getFromTrainer() + ", req id =" + acceptRequest.getRequestId() + "\n");
        }
        else if(requestDiet != null){
            requestText.setText("Diet req from client " + requestDiet.getClientId() + ": " + requestDiet.getRequest());
            notifyTextT.appendText("Diet req from client " + requestDiet.getClientId() + ": " + requestDiet.getRequest() + "\n");
        }
        else{
            requestText.setText("No requests");
        }
    }

    public void acceptRequest(){
        String text = requestText.getText();
        String requestId = new String("");
        if(text.charAt(text.length()-2) == '='){
            requestId = requestId.concat(String.valueOf(text.charAt(text.length() - 1)));
        }else{
            String aux1 = String.valueOf(text.charAt(text.length() - 2));
            String aux2 = String.valueOf(text.charAt(text.length() - 1));
            requestId = requestId.concat(aux1);
            requestId = requestId.concat(aux2);
        }
        String status = "accept";
        if(text.charAt(0) == 'C'){
            TransmissionFunc.setFromTrainerStat(requestId, status);
        }else if(text.charAt(0) == 'A'){
            TransmissionFunc.setToTrainerStat(requestId, status);
        }
    }

    public void denyRequest(){
        String text = requestText.getText();
        String requestId = new String("");
        if(text.charAt(text.length()-2) == '='){
            requestId = requestId.concat(String.valueOf(text.charAt(text.length() - 1)));
        }else{
            String aux1 = String.valueOf(text.charAt(text.length() - 2));
            String aux2 = String.valueOf(text.charAt(text.length() - 1));
            requestId = requestId.concat(aux1);
            requestId = requestId.concat(aux2);
        }
        String status = "deny";
        if(text.charAt(0) == 'C'){
            TransmissionFunc.setFromTrainerStat(requestId, status);
        }else if(text.charAt(0) == 'A'){
            TransmissionFunc.setToTrainerStat(requestId, status);
        }
    }

    public void sendDiet(){
        String[] values = dietTxt.getText().split(",");
        String dietName = values[0];
        String clientId = values[1];
        TransmissionFunc.changeDiet(clientId, dietName);
    }

    @Override
    public void update() {
//        if(clientService.findByTrainerAndName(LoginController.trainerLogin, LoginController.clientLogin.getName()) != null){
//            notifyTextT.appendText(LoginController.subject.getState() + "\n");
//        }
    }
}
