package com.project.reports;

import com.project.Socket.TransmissionFunc;
import com.project.dao.ActivityDAO;
import com.project.dao.DietDAO;
import com.project.dao.FoodDAO;
import com.project.dao.ProgramDAO;
import javafx.stage.FileChooser;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class TextReport implements Report{

    @Override
    public void createReport(int trainerId) {
        PrintWriter writer;
        List<String> namePass = TransmissionFunc.getTrainerNamePass(Integer.toString(trainerId));
        String trainerName = namePass.get(0);
        String trainerPassword = namePass.get(1);
        String title = "Report for Trainer with id " + trainerId + ".txt";
        List<ProgramDAO> programs = TransmissionFunc.getAllPrograms(trainerName, trainerPassword);
        List<DietDAO> diets = TransmissionFunc.getAllDiets(trainerName, trainerPassword);
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName(title);
            File file = fileChooser.showSaveDialog(null);

            writer = new PrintWriter(file);
            for(int i=0; i<programs.size(); i++){
                writer.println("Program name: " + programs.get(i).getName());
                //List<Activity> activities = programs.get(i).getActivities();
                List<ActivityDAO> activities = TransmissionFunc.getProgramActivities(Integer.toString(programs.get(i).getProgramId()));
                for(int j=0; j<activities.size(); j++){
                    String activityData = "Activity name: " + activities.get(j).getName() + ", Activity duration: " + activities.get(j).getDuration() + ", Activity intensity: " + activities.get(j).getIntensity();
                    writer.println(activityData);
                }
                writer.println(" ");
            }
            for(int i=0; i<diets.size(); i++){
                writer.println("Diet name: " + diets.get(i).getDietName());
                //List<Food> foods = diets.get(i).getFoods();
                List<FoodDAO> foods = TransmissionFunc.getDietFood(Integer.toString(diets.get(i).getDietId()));
                for(int j=0; j<foods.size(); j++){
                    String foodData = "Food name: " + foods.get(j).getName() + ", Food prep duration: " + foods.get(j).getDuration() + ", Food calorie count: " + foods.get(j).getCaloriesCount();
                    writer.println(foodData);
                }
                writer.println(" ");
            }
            writer.close();
        } catch (FileNotFoundException /*| UnsupportedEncodingException*/ e) {
            e.printStackTrace();
        }
    }
}
