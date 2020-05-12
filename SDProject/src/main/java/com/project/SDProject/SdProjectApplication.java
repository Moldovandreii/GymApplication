package com.project.SDProject;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.project.repository")
@EntityScan( basePackages = {"com.project.entities"} )
@ComponentScan( basePackages = {"com.project"} )
public class SdProjectApplication {

	public static void main(String[] args) {

		Application.launch(JavaFxApplication.class, args);
	}

}
