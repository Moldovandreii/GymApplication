package com.project.controller;

import com.project.Socket.TransmissionFunc;
import com.project.dao.DietDAO;
import com.project.dao.TrainerDAO;
import com.project.util.AlertBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("client.fxml")
public class ClientController implements Initializable {
    @FXML
    Label loggedInTxt;
    @FXML
    Label attendances;
    @FXML
    Label myTrainerTxt;
    @FXML
    ComboBox<String> rating;
    @FXML
    public TableView<TrainerDAO> Trainers;
    @FXML
    public TableColumn<TrainerDAO, Integer> trainerId;
    @FXML
    public TableColumn<TrainerDAO, String> trainerName;
    @FXML
    public TableColumn<TrainerDAO, String> trainerMail;
    @FXML
    public TableColumn<TrainerDAO, Float> trainerReview;
    @FXML
    public TableColumn<TrainerDAO, Integer> trainerReviews;
    @FXML
    public TextField changeId;
    @FXML
    public TextField changeDiet;



    public void showAttendance() {
        Date date = TransmissionFunc.showAttendance(LoginController.usernameLoging, LoginController.passwordLogin);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        loggedInTxt.setText(strDate);
        attendances.setText(TransmissionFunc.getAttendance(LoginController.usernameLoging, LoginController.passwordLogin));

        TrainerDAO trainer = TransmissionFunc.findTrainerByClient(LoginController.usernameLoging, LoginController.passwordLogin);
        myTrainerTxt.setText(trainer.getUsername());
    }

    public void setRating(){
        String r = rating.getValue();
        TrainerDAO trainer = TransmissionFunc.findTrainerByClient(LoginController.usernameLoging, LoginController.passwordLogin);
        TransmissionFunc.rateTrainer(r, Integer.toString(trainer.getTrainerId()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trainerId.setCellValueFactory(new PropertyValueFactory<TrainerDAO, Integer>("trainerId"));
        trainerName.setCellValueFactory(new PropertyValueFactory<TrainerDAO, String>("username"));
        trainerMail.setCellValueFactory((new PropertyValueFactory<TrainerDAO, String>("mail")));
        trainerReview.setCellValueFactory((new PropertyValueFactory<TrainerDAO, Float>("review")));
        trainerReviews.setCellValueFactory((new PropertyValueFactory<TrainerDAO, Integer>("reviews")));
        Trainers.getItems().setAll(TransmissionFunc.getAllTrainers());
    }

    public void updateTrainerT(){
        trainerId.setCellValueFactory(new PropertyValueFactory<TrainerDAO, Integer>("trainerId"));
        trainerName.setCellValueFactory(new PropertyValueFactory<TrainerDAO, String>("username"));
        trainerMail.setCellValueFactory((new PropertyValueFactory<TrainerDAO, String>("mail")));
        trainerReview.setCellValueFactory((new PropertyValueFactory<TrainerDAO, Float>("review")));
        trainerReviews.setCellValueFactory((new PropertyValueFactory<TrainerDAO, Integer>("reviews")));
        Trainers.getItems().setAll(TransmissionFunc.getAllTrainers());
    }

    public void requestChange(){
        String newTrainer = changeId.getText();
        TrainerDAO trainer = TransmissionFunc.findTrainerByClient(LoginController.usernameLoging, LoginController.passwordLogin);
        TransmissionFunc.requestChange(Integer.toString(trainer.getTrainerId()), newTrainer, LoginController.usernameLoging, LoginController.passwordLogin);
    }

    public void requestNewDiet(){
        String clientId = TransmissionFunc.findClientByNameAndPass(LoginController.usernameLoging, LoginController.passwordLogin);
        String text = changeDiet.getText();
        TransmissionFunc.sendDietRequest(clientId, text);
    }

    public void showDiet(){
        String clientId = TransmissionFunc.findClientByNameAndPass(LoginController.usernameLoging, LoginController.passwordLogin);
        DietDAO diet = TransmissionFunc.getClientsDiet(clientId);
        List<String> foods = diet.getFoods();
        String foodStr = new String(", Food List: ");
        for(int i=0; i<foods.size(); i++){
            foodStr = foodStr.concat(foods.get(i));
            if(i != foods.size()-1){
                foodStr = foodStr.concat(", ");
            }
        }
        AlertBox.display("My diet", "Dietname: " + diet.getDietName() + foodStr);
    }
}
