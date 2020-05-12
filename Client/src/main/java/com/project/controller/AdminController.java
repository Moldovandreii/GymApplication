package com.project.controller;

import com.itextpdf.text.DocumentException;
import com.project.Socket.TransmissionFunc;
import com.project.dao.ActivityDAO;
import com.project.dao.FoodDAO;
import com.project.dao.TrainerDAO;
import com.project.reports.Report;
import com.project.reports.ReportFactory;
import com.project.util.AlertBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("admin.fxml")
public class AdminController implements Initializable {
    @FXML
    public TextField mail;
    @FXML
    public TextField name;
    @FXML
    public TextField password;
    @FXML
    public TextField id;
    @FXML
    public Button createTrainer;
    @FXML
    public Button updateTrainer;
    @FXML
    public Button deleteTrainer;
    @FXML
    public Button findTrainer;
    @FXML
    public Button updateTrainerT;
    @FXML
    public TableView<TrainerDAO> Trainers;
    @FXML
    public TableColumn<TrainerDAO, Integer> trainerId;
    @FXML
    public TableColumn<TrainerDAO, String> trainerName;
    @FXML
    public TableColumn<TrainerDAO, String> trainerPassword;
    @FXML
    public TableColumn<TrainerDAO, String> trainerMail;


    @FXML
    public TextField foodName;
    @FXML
    public TextField foodDuration;
    @FXML
    public TextField foodCalories;
    @FXML
    public TextField foodId;
    @FXML
    public Button createFood;
    @FXML
    public Button updateFood;
    @FXML
    public Button deleteFood;
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
    public TextField activityName;
    @FXML
    public TextField activityDuration;
    @FXML
    public TextField activityIntensity;
    @FXML
    public TextField activityId;
    @FXML
    public Button createActivity;
    @FXML
    public Button updateActivity;
    @FXML
    public Button deleteActivity;
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
    public TextField trainerIdR;
    @FXML
    public Button createTxtReport;
    @FXML
    public Button createPdfReport;


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

    public void createTrainer(){
        TransmissionFunc.createTrainer(name.getText(), mail.getText(), password.getText());
    }


    public void updateTrainer(){
        if(TransmissionFunc.findTrainerById(id.getText()).equals("exists")){
            TransmissionFunc.updateTrainer(name.getText(), mail.getText(), password.getText(), id.getText());
        }else{
            AlertBox.display("No user", "Enter a valid id");
        }
    }


    public void deleteTrainer(){
        if(TransmissionFunc.findTrainerById(id.getText()).equals("exists")){
            TransmissionFunc.deleteTrainer(id.getText());
        }
        else{
            AlertBox.display("No user", "Enter a valid id");
        }
    }

    public void findTrainer(){
        if(TransmissionFunc.findTrainerById(id.getText()).equals("exists")){
            String trainer = TransmissionFunc.findNameById(id.getText());
            AlertBox.display("user", trainer);
        }else{
            AlertBox.display("No user", "Enter a valid id");
        }
    }

    public void createFood(){
        TransmissionFunc.createFood(foodName.getText(), foodDuration.getText(), foodCalories.getText());
    }

    public void updateFood(){
        if(TransmissionFunc.findFoodById(foodId.getText()).equals("exists")){
            TransmissionFunc.updateFood(foodName.getText(), foodDuration.getText(), foodCalories.getText(), foodId.getText());
        }
        else{
            AlertBox.display("No food", "Enter a valid id");
        }
    }

    public void deleteFood(){
        if(TransmissionFunc.findFoodById(foodId.getText()).equals("exists")){
            TransmissionFunc.deleteFood(foodId.getText());
        }
        else{
            AlertBox.display("No food", "Enter a valid id");
        }
    }

    public void createActivity(){
        TransmissionFunc.createActivity(activityName.getText(), activityDuration.getText(), activityIntensity.getText());
    }

    public void updateActivity(){
        if(TransmissionFunc.findActivityById(activityId.getText()).equals("exists")){
            TransmissionFunc.updateActivity(activityName.getText(), activityDuration.getText(), activityIntensity.getText(), activityId.getText());
        }
        else{
            AlertBox.display("No activity", "Enter a valid id");
        }
    }

    public void deleteActivity(){
        if(TransmissionFunc.findActivityById(activityId.getText()).equals("exists")){
            TransmissionFunc.deleteActivity(activityId.getText());
        }
        else{
            AlertBox.display("No activity", "Enter a valid id");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trainerId.setCellValueFactory(new PropertyValueFactory<TrainerDAO, Integer>("trainerId"));
        trainerName.setCellValueFactory(new PropertyValueFactory<TrainerDAO, String>("username"));
        trainerPassword.setCellValueFactory((new PropertyValueFactory<TrainerDAO, String>("password")));
        trainerMail.setCellValueFactory((new PropertyValueFactory<TrainerDAO, String>("mail")));
        //Trainers.getItems().setAll(trainerService.getAllTrainers());
        Trainers.getItems().setAll(TransmissionFunc.getAllTrainers());

        foodIdT.setCellValueFactory(new PropertyValueFactory<FoodDAO, Integer>("foodId"));
        foodNameT.setCellValueFactory(new PropertyValueFactory<FoodDAO, String>("name"));
        foodDurationT.setCellValueFactory((new PropertyValueFactory<FoodDAO, Integer>("duration")));
        foodCaloriesT.setCellValueFactory((new PropertyValueFactory<FoodDAO, Integer>("caloriesCount")));
        //Foods.getItems().setAll(foodService.getAllFood());
        Foods.getItems().setAll(TransmissionFunc.getAllFood());

        activityIdT.setCellValueFactory(new PropertyValueFactory<ActivityDAO, Integer>("activityId"));
        activityNameT.setCellValueFactory(new PropertyValueFactory<ActivityDAO, String>("name"));
        activityDurationT.setCellValueFactory((new PropertyValueFactory<ActivityDAO, Integer>("duration")));
        activityIntensityT.setCellValueFactory((new PropertyValueFactory<ActivityDAO, Integer>("intensity")));
        //Activities.getItems().setAll(activityService.getAllActivities());
        Activities.getItems().setAll(TransmissionFunc.getAllActivities());
    }

    public void updateTrainerT(){
        trainerId.setCellValueFactory(new PropertyValueFactory<TrainerDAO, Integer>("trainerId"));
        trainerName.setCellValueFactory(new PropertyValueFactory<TrainerDAO, String>("username"));
        trainerPassword.setCellValueFactory((new PropertyValueFactory<TrainerDAO, String>("password")));
        trainerMail.setCellValueFactory((new PropertyValueFactory<TrainerDAO, String>("mail")));
        //Trainers.getItems().setAll(trainerService.getAllTrainers());
        Trainers.getItems().setAll(TransmissionFunc.getAllTrainers());
    }

    public void updateFoodT(){
        foodIdT.setCellValueFactory(new PropertyValueFactory<FoodDAO, Integer>("foodId"));
        foodNameT.setCellValueFactory(new PropertyValueFactory<FoodDAO, String>("name"));
        foodDurationT.setCellValueFactory((new PropertyValueFactory<FoodDAO, Integer>("duration")));
        foodCaloriesT.setCellValueFactory((new PropertyValueFactory<FoodDAO, Integer>("caloriesCount")));
        //Foods.getItems().setAll(foodService.getAllFood());
        Foods.getItems().setAll(TransmissionFunc.getAllFood());
    }

    public void updateActivityT(){
        activityIdT.setCellValueFactory(new PropertyValueFactory<ActivityDAO, Integer>("activityId"));
        activityNameT.setCellValueFactory(new PropertyValueFactory<ActivityDAO, String>("name"));
        activityDurationT.setCellValueFactory((new PropertyValueFactory<ActivityDAO, Integer>("duration")));
        activityIntensityT.setCellValueFactory((new PropertyValueFactory<ActivityDAO, Integer>("intensity")));
        //Activities.getItems().setAll(activityService.getAllActivities());
        Activities.getItems().setAll(TransmissionFunc.getAllActivities());
    }

    public void createTxtReport() throws FileNotFoundException, DocumentException {
        ReportFactory reportFactory = new ReportFactory();
        Report report = reportFactory.getReportType("TextReport");
        int trainerId = Integer.parseInt(trainerIdR.getText());
        report.createReport(trainerId);
    }

    public void createPdfReport() throws FileNotFoundException, DocumentException {
        ReportFactory reportFactory = new ReportFactory();
        Report report = reportFactory.getReportType("PdfReport");
        int trainerId = Integer.parseInt(trainerIdR.getText());
        report.createReport(trainerId);
    }
}

