//package com.project.controller;
//
//import com.project.ObserverDP.Observer;
//import com.project.entities.Activity;
//import com.project.entities.Client;
//import com.project.entities.Food;
//import com.project.services.*;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import net.rgielen.fxweaver.core.FxmlView;
//import org.springframework.stereotype.Component;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//@Component
//@FxmlView("trainer.fxml")
//public class TrainerController extends Observer implements Initializable{
//    @FXML
//    public TextField programName;
//    @FXML
//    public TextField programActivities;
//    @FXML
//    public Button createProgram;
//    @FXML
//    public TableView<Activity> Activities;
//    @FXML
//    public TableColumn<Activity, Integer> activityIdT;
//    @FXML
//    public TableColumn<Activity, String> activityNameT;
//    @FXML
//    public TableColumn<Activity, Integer> activityDurationT;
//    @FXML
//    public TableColumn<Activity, Integer> activityIntensityT;
//
//    @FXML
//    public TextField dietName;
//    @FXML
//    public TextField dietFoods;
//    @FXML
//    public Button createDiet;
//    @FXML
//    public TableView<Food> Foods;
//    @FXML
//    public TableColumn<Food, Integer> foodIdT;
//    @FXML
//    public TableColumn<Food, String> foodNameT;
//    @FXML
//    public TableColumn<Food, Integer> foodDurationT;
//    @FXML
//    public TableColumn<Food, Integer> foodCaloriesT;
//
//    @FXML
//    public TextField clientName;
//    @FXML
//    public TextField clientPassword;
//    @FXML
//    public Button createClient;
//    @FXML
//    public Button updateClient;
//    @FXML
//    public TableView<Client> Clients;
//    @FXML
//    public TableColumn<Client, Integer> clientIdT;
//    @FXML
//    public TableColumn<Client, String> clientNameT;
//    @FXML
//    public TableColumn<Client, String> clientPasswordT;
//    @FXML
//    public TableColumn<Client, Integer> clientAttendanceT;
//
//    @FXML
//    public TextArea notifyTextT;
//
//
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
//
//    public void createProgram(){
//        String activityIds = programActivities.getText();
//        List<Activity> activities = new ArrayList<Activity>();
//        for(int i=0; i<activityIds.length(); i++){
//            if(activityIds.charAt(i) != ','){
//                int id = Integer.parseInt(String.valueOf(activityIds.charAt(i)));
//                Activity activity = activityService.findById(id);
//                activities.add(activity);
//            }
//        }
//        programService.createProgram(programName.getText(), LoginController.trainerLogin, activities);
//    }
//
//    public void createDiet(){
//        String foodIds = dietFoods.getText();
//        List<Food> foods = new ArrayList<Food>();
//        for(int i=0; i<foodIds.length(); i++){
//            if(foodIds.charAt(i) != ','){
//                int id = Integer.parseInt(String.valueOf(foodIds.charAt(i)));
//                Food food = foodService.findById(id);
//                foods.add(food);
//            }
//        }
//        dietService.createDiet(dietName.getText(), LoginController.trainerLogin, foods);
//    }
//
//    public void createClient(){
//        clientService.createClient(clientName.getText(), clientPassword.getText(), LoginController.trainerLogin);
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        foodIdT.setCellValueFactory(new PropertyValueFactory<Food, Integer>("foodId"));
//        foodNameT.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
//        foodDurationT.setCellValueFactory((new PropertyValueFactory<Food, Integer>("duration")));
//        foodCaloriesT.setCellValueFactory((new PropertyValueFactory<Food, Integer>("caloriesCount")));
//        Foods.getItems().setAll(foodService.getAllFood());
//
//        activityIdT.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("activityId"));
//        activityNameT.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
//        activityDurationT.setCellValueFactory((new PropertyValueFactory<Activity, Integer>("duration")));
//        activityIntensityT.setCellValueFactory((new PropertyValueFactory<Activity, Integer>("intensity")));
//        Activities.getItems().setAll(activityService.getAllActivities());
//
//        clientIdT.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clientId"));
//        clientNameT.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
//        clientPasswordT.setCellValueFactory(new PropertyValueFactory<Client, String>("password"));
//        clientAttendanceT.setCellValueFactory(new PropertyValueFactory<Client, Integer>("attendance"));
//        Clients.getItems().setAll(clientService.findByTrainer(LoginController.trainerLogin));
//    }
//
//    public void updateClient(){
//        clientIdT.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clientId"));
//        clientNameT.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
//        clientPasswordT.setCellValueFactory(new PropertyValueFactory<Client, String>("password"));
//        clientAttendanceT.setCellValueFactory(new PropertyValueFactory<Client, Integer>("attendance"));
//        Clients.getItems().setAll(clientService.findByTrainer(LoginController.trainerLogin));
//    }
//
//    @Override
//    public void update() {
//        if(clientService.findByTrainerAndName(LoginController.trainerLogin, LoginController.clientLogin.getName()) != null){
//            notifyTextT.appendText(LoginController.subject.getState() + "\n");
//        }
//    }
//}
