package com.project.controller;

import com.project.ObserverDP.Subject;
import com.project.SDProject.JavaFxApplication;
import com.project.Socket.TransmissionFunc;
import com.project.util.AlertBox;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@FxmlView("login.fxml")
public class LoginController {

    @FXML
    public Button loginButton;
    @FXML
    public TextField username;
    @FXML
    public TextField password;

    public static String usernameLoging;
    public static String passwordLogin;

//    public static Trainer trainerLogin;
//    public static Client clientLogin;
//
//    private ServiceFunctions serviceFunctions;
//    private ClientService clientService;

    public static Subject subject = new Subject();

//    @Autowired
//    public LoginController(ServiceFunctions serviceFunctions, ClientService clientService) {
//        this.serviceFunctions = serviceFunctions;
//        this.clientService = clientService;
//    }

    public void login() throws IOException {
        String logger = TransmissionFunc.loginFunc(username.getText(), password.getText());
        if(username.getText().equals("") || password.getText().equals("")){
            AlertBox.display("No input", "You forgot to write your mail/password");
        }
        if(logger.equals("Admin")){
            Scene adminScene = JavaFxApplication.changeScene(AdminController.class, "Admin");
            adminScene.getStylesheets().add("Style.css");
        }else if(logger.equals("Trainer")) {
            Scene trainerScene = JavaFxApplication.changeScene(TrainerController.class, "Trainer");
            trainerScene.getStylesheets().add("Style.css");
            //trainerLogin = serviceFunctions.getTrainer(username.getText(), password.getText());
            usernameLoging = username.getText();
            passwordLogin = password.getText();
        }else if(logger.equals("Client")){
            Scene clientScene = JavaFxApplication.changeScene(ClientController.class, "Client");
            clientScene.getStylesheets().add("Style.css");
            //clientLogin = serviceFunctions.getClient(username.getText(), password.getText());
            subject.setState("Client " + username.getText() + " has logged in");
            //clientService.update(clientLogin.getClientId(), clientLogin.getName(), clientLogin.getPassword(), clientLogin.getTrainer());
            usernameLoging = username.getText();
            passwordLogin = password.getText();
            TransmissionFunc.updateClientLogin(usernameLoging, passwordLogin);
        } else{
            AlertBox.display("No match", "Enter a valid user");
        }
    }
}