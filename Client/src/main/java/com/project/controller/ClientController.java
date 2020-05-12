package com.project.controller;

import com.project.Socket.TransmissionFunc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@FxmlView("client.fxml")
public class ClientController {
    @FXML
    Label loggedInTxt;
    @FXML
    Label attendances;

    public void showAttendance() {
        Date date = TransmissionFunc.showAttendance(LoginController.usernameLoging, LoginController.passwordLogin);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        loggedInTxt.setText(strDate);
        attendances.setText(TransmissionFunc.getAttendance(LoginController.usernameLoging, LoginController.passwordLogin));
    }
}
