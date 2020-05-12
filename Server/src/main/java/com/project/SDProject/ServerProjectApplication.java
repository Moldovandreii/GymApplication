package com.project.SDProject;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories("com.project.repository")
@EntityScan( basePackages = {"com.project.entities"} )
@ComponentScan( basePackages = {"com.project"} )
public class ServerProjectApplication {

    //public static Socket socket;

    public static void main(String[] args) throws IOException {

//        ServerSocket ss = new ServerSocket(6666);
//        socket = ss.accept();
        //Transmission.sendToClient(socket, "bai clientule cf");
        //System.out.println(Transmission.receiveFromClient(socket));


//        String received = Transmission.receiveFromClient(socket);
//        String[] values = received.split(",");
//        String function = values[0];


        //TransmissionFunc.sendBack(socket, values);

        Application.launch(JavaFxApplication.class, args);

    }

}
