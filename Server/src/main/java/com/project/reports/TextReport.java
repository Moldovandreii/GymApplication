//package com.project.reports;
//
//import com.project.entities.Activity;
//import com.project.entities.Diet;
//import com.project.entities.Food;
//import com.project.entities.Program;
//import com.project.services.DietService;
//import com.project.services.ProgramService;
//import com.project.services.TrainerService;
//import javafx.stage.FileChooser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@Service
//public class TextReport implements Report{
//
//    private TrainerService trainerService;
//    private ProgramService programService;
//    private DietService dietService;
//
//    @Autowired
//    public TextReport(TrainerService trainerService, ProgramService programService, DietService dietService){
//        this.trainerService = trainerService;
//        this.programService = programService;
//        this.dietService = dietService;
//    }
//
//    @Override
//    public void createReport(int trainerId) {
//        PrintWriter writer;
//        String title = "Report for Trainer with id " + trainerId + ".txt";
//        List<Program> programs = programService.findByTrainer(trainerService.findById(trainerId));
//        List<Diet> diets = dietService.findByTrainer(trainerService.findById(trainerId));
//        try{
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setInitialFileName(title);
//            File file = fileChooser.showSaveDialog(null);
//
//            writer = new PrintWriter(file);
//            for(int i=0; i<programs.size(); i++){
//                writer.println("Program name: " + programs.get(i).getProgramName());
//                List<Activity> activities = programs.get(i).getActivities();
//                for(int j=0; j<activities.size(); j++){
//                    String activityData = "Activity name: " + activities.get(j).getName() + ", Activity duration: " + activities.get(j).getDuration() + ", Activity intensity: " + activities.get(j).getIntensity();
//                    writer.println(activityData);
//                }
//                writer.println(" ");
//            }
//            for(int i=0; i<diets.size(); i++){
//                writer.println("Diet name: " + diets.get(i).getDietName());
//                List<Food> foods = diets.get(i).getFoods();
//                for(int j=0; j<foods.size(); j++){
//                    String foodData = "Food name: " + foods.get(j).getName() + ", Food prep duration: " + foods.get(j).getDuration() + ", Food calorie count: " + foods.get(j).getCaloriesCount();
//                    writer.println(foodData);
//                }
//                writer.println(" ");
//            }
//            writer.close();
//        } catch (FileNotFoundException /*| UnsupportedEncodingException*/ e) {
//            e.printStackTrace();
//        }
//    }
//}
