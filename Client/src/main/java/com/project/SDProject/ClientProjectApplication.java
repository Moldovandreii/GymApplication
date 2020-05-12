package com.project.SDProject;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.*;
import java.net.Socket;

@SpringBootApplication
@EnableJpaRepositories("com.project.repository")
@EntityScan( basePackages = {"com.project.entities"} )
@ComponentScan( basePackages = {"com.project"} )
public class ClientProjectApplication {

    public static Socket socket;
    public static ObjectInputStream objectInputStream;
    public static ObjectOutputStream objectOutputStream;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        socket = new Socket("localhost", 6666);

        InputStream inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);

       // OutputStream outputStream = socket.getOutputStream();
        //objectOutputStream = new ObjectOutputStream(outputStream);

        //Transmission.sendToServer(socket, "getAllTrainers");
        //List<String> mewsage = (List<String>)objectInputStream.readObject();
        //List<Trainer> trainers = (List<Trainer>)objectInputStream.readObject();

        //System.out.println(Transmission.receiveFromServer(socket));
        //Transmission.sendToServer(socket, "bai server");

        Application.launch(JavaFxApplication.class, args);


    }

}