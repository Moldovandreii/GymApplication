//package com.project.controller;
//
//import com.itextpdf.text.DocumentException;
//import com.project.entities.Activity;
//import com.project.entities.Food;
//import com.project.entities.Trainer;
//import com.project.reports.Report;
//import com.project.reports.ReportFactory;
//import com.project.services.*;
//import com.project.util.AlertBox;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import net.rgielen.fxweaver.core.FxmlView;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.FileNotFoundException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//@Component
//@FxmlView("admin.fxml")
//public class AdminController implements Initializable {
//    @FXML
//    public TextField mail;
//    @FXML
//    public TextField name;
//    @FXML
//    public TextField password;
//    @FXML
//    public TextField id;
//    @FXML
//    public Button createTrainer;
//    @FXML
//    public Button updateTrainer;
//    @FXML
//    public Button deleteTrainer;
//    @FXML
//    public Button findTrainer;
//    @FXML
//    public Button updateTrainerT;
//    @FXML
//    public TableView<Trainer> Trainers;
//    @FXML
//    public TableColumn<Trainer, Integer> trainerId;
//    @FXML
//    public TableColumn<Trainer, String> trainerName;
//    @FXML
//    public TableColumn<Trainer, String> trainerPassword;
//    @FXML
//    public TableColumn<Trainer, String> trainerMail;
//
//
//    @FXML
//    public TextField foodName;
//    @FXML
//    public TextField foodDuration;
//    @FXML
//    public TextField foodCalories;
//    @FXML
//    public TextField foodId;
//    @FXML
//    public Button createFood;
//    @FXML
//    public Button updateFood;
//    @FXML
//    public Button deleteFood;
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
//    public TextField activityName;
//    @FXML
//    public TextField activityDuration;
//    @FXML
//    public TextField activityIntensity;
//    @FXML
//    public TextField activityId;
//    @FXML
//    public Button createActivity;
//    @FXML
//    public Button updateActivity;
//    @FXML
//    public Button deleteActivity;
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
//    public TextField trainerIdR;
//    @FXML
//    public Button createTxtReport;
//    @FXML
//    public Button createPdfReport;
//
//
//    private TrainerService trainerService;
//    private FoodService foodService;
//    private ActivityService activityService;
//    private ProgramService programService;
//    private DietService dietService;
//
//    @Autowired
//    public AdminController(TrainerService trainerService, FoodService foodService, ActivityService activityService, ProgramService programService, DietService dietService){
//        this.trainerService = trainerService;
//        this.foodService = foodService;
//        this.activityService = activityService;
//        this.programService = programService;
//        this.dietService = dietService;
//    }
//
//    public void createTrainer(){
//        trainerService.create(name.getText(), mail.getText(), password.getText());
//    }
//
//    public void updateTrainer(){
//        if(trainerService.findById(Integer.parseInt(id.getText())) != null){
//            trainerService.update(name.getText(), mail.getText(), password.getText(), Integer.parseInt(id.getText()));
//        }
//        else{
//            AlertBox.display("No user", "Enter a valid id");
//        }
//    }
//
//    public void deleteTrainer(){
//        if(trainerService.findById(Integer.parseInt(id.getText())) != null){
//            trainerService.delete(Integer.parseInt(id.getText()));
//        }
//        else{
//            AlertBox.display("No user", "Enter a valid id");
//        }
//    }
//
//    public void findTrainer(){
//        if(trainerService.findById(Integer.parseInt(id.getText())) != null){
//            String trainer = trainerService.findById(Integer.parseInt(id.getText())).toString();
//            AlertBox.display("user", trainer);
//        }else{
//            AlertBox.display("No user", "Enter a valid id");
//        }
//    }
//
//    public void createFood(){
//        foodService.create(foodName.getText(), Integer.parseInt(foodDuration.getText()), Integer.parseInt(foodCalories.getText()));
//    }
//
//    public void updateFood(){
//        if(foodService.findById(Integer.parseInt(foodId.getText())) != null){
//            foodService.update(foodName.getText(), Integer.parseInt(foodDuration.getText()), Integer.parseInt(foodCalories.getText()), Integer.parseInt(foodId.getText()));
//        }
//        else{
//            AlertBox.display("No food", "Enter a valid id");
//        }
//    }
//
//    public void deleteFood(){
//        if(foodService.findById(Integer.parseInt(foodId.getText())) != null){
//            foodService.delete(Integer.parseInt(foodId.getText()));
//        }
//        else{
//            AlertBox.display("No food", "Enter a valid id");
//        }
//    }
//
//    public void createActivity(){
//        activityService.create(activityName.getText(), Integer.parseInt(activityDuration.getText()), Integer.parseInt(activityIntensity.getText()));
//    }
//
//    public void updateActivity(){
//        if(activityService.findById(Integer.parseInt(activityId.getText())) != null){
//            activityService.update(activityName.getText(), Integer.parseInt(activityDuration.getText()), Integer.parseInt(activityIntensity.getText()), Integer.parseInt(activityId.getText()));
//        }
//        else{
//            AlertBox.display("No activity", "Enter a valid id");
//        }
//    }
//
//    public void deleteActivity(){
//        if(activityService.findById(Integer.parseInt(activityId.getText())) != null){
//            activityService.delete(Integer.parseInt(activityId.getText()));
//        }
//        else{
//            AlertBox.display("No activity", "Enter a valid id");
//        }
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        trainerId.setCellValueFactory(new PropertyValueFactory<Trainer, Integer>("trainerId"));
//        trainerName.setCellValueFactory(new PropertyValueFactory<Trainer, String>("username"));
//        trainerPassword.setCellValueFactory((new PropertyValueFactory<Trainer, String>("password")));
//        trainerMail.setCellValueFactory((new PropertyValueFactory<Trainer, String>("mail")));
//        Trainers.getItems().setAll(trainerService.getAllTrainers());
//
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
//    }
//
//    public void updateTrainerT(){
//        trainerId.setCellValueFactory(new PropertyValueFactory<Trainer, Integer>("trainerId"));
//        trainerName.setCellValueFactory(new PropertyValueFactory<Trainer, String>("username"));
//        trainerPassword.setCellValueFactory((new PropertyValueFactory<Trainer, String>("password")));
//        trainerMail.setCellValueFactory((new PropertyValueFactory<Trainer, String>("mail")));
//        Trainers.getItems().setAll(trainerService.getAllTrainers());
//    }
//
//    public void updateFoodT(){
//        foodIdT.setCellValueFactory(new PropertyValueFactory<Food, Integer>("foodId"));
//        foodNameT.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
//        foodDurationT.setCellValueFactory((new PropertyValueFactory<Food, Integer>("duration")));
//        foodCaloriesT.setCellValueFactory((new PropertyValueFactory<Food, Integer>("caloriesCount")));
//        Foods.getItems().setAll(foodService.getAllFood());
//    }
//
//    public void updateActivityT(){
//        activityIdT.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("activityId"));
//        activityNameT.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
//        activityDurationT.setCellValueFactory((new PropertyValueFactory<Activity, Integer>("duration")));
//        activityIntensityT.setCellValueFactory((new PropertyValueFactory<Activity, Integer>("intensity")));
//        Activities.getItems().setAll(activityService.getAllActivities());
//    }
//
//    public void createTxtReport() throws FileNotFoundException, DocumentException {
//        ReportFactory reportFactory = new ReportFactory();
//        Report report = reportFactory.getReportType("TextReport", trainerService, programService, dietService);
//        int trainerId = Integer.parseInt(trainerIdR.getText());
//        report.createReport(trainerId);
//    }
//
//    public void createPdfReport() throws FileNotFoundException, DocumentException {
//        ReportFactory reportFactory = new ReportFactory();
//        Report report = reportFactory.getReportType("PdfReport", trainerService, programService, dietService);
//        int trainerId = Integer.parseInt(trainerIdR.getText());
//        report.createReport(trainerId);
//    }
//}
//
