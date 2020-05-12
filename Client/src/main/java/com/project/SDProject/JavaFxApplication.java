package com.project.SDProject;

import com.project.controller.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class JavaFxApplication extends Application {
    private static ConfigurableApplicationContext applicationContext;
   // public static Socket socket;

    @Override
    public void init() throws IOException {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        applicationContext = new SpringApplicationBuilder()
                .sources(ClientProjectApplication.class)
                .run(args);
        //socket = new Socket("localhost", 9806);
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LoginController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static Scene changeScene(Class controller, String title) throws IOException {

        //ClassLoader classLoader = JavaFxApplication.class.getClassLoader();
        //URL loader = classLoader.getResource(fxml);
        //System.out.println(loader);
        //Parent pane = FXMLLoader.load(loader);

        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent pane = fxWeaver.loadView((Class<Object>) controller);

        Stage stage = new Stage();
        Scene newScene = new Scene(pane);
        newScene.getStylesheets().add("Style.css");
        stage.setScene(newScene);
        stage.setTitle(title);
        stage.show();

        return newScene;
    }
}
