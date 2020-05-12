package com.project.controller;

import com.project.ObserverDP.Observer;
import com.project.Socket.TransmissionFunc;
import com.project.dao.ActivityDAO;
import com.project.dao.ClientDAO;
import com.project.dao.FoodDAO;
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

    @Override
    public void update() {
//        if(clientService.findByTrainerAndName(LoginController.trainerLogin, LoginController.clientLogin.getName()) != null){
//            notifyTextT.appendText(LoginController.subject.getState() + "\n");
//        }
    }
}
