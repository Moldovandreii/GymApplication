//package com.project.reports;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.project.entities.Activity;
//import com.project.entities.Diet;
//import com.project.entities.Food;
//import com.project.entities.Program;
//import com.project.services.*;
//import javafx.stage.FileChooser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.List;
//
//@Service
//public class PdfReport implements Report{
//
//    private TrainerService trainerService;
//    private ProgramService programService;
//    private DietService dietService;
//
//    @Autowired
//    public PdfReport(TrainerService trainerService, ProgramService programService, DietService dietService){
//        this.trainerService = trainerService;
//        this.programService = programService;
//        this.dietService = dietService;
//    }
//
//    @Override
//    public void createReport(int trainerId) {
//        List<Program> programs = programService.findByTrainer(trainerService.findById(trainerId));
//        List<Diet> diets = dietService.findByTrainer(trainerService.findById(trainerId));
//        Document document = new Document();
//        String title = "Report for Trainer with id " + trainerId + ".pdf";
//        try{
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setInitialFileName(title);
//            File file = fileChooser.showSaveDialog(null);
//            PdfWriter.getInstance(document, new FileOutputStream(file));
//            document.open();
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//            for(int i=0; i<programs.size(); i++){
//                document.add(new Paragraph("Program name: " + programs.get(i).getProgramName()));
//                List<Activity> activities = programs.get(i).getActivities();
//                for(int j=0; j<activities.size(); j++){
//                    String activityData = "Activity name: " + activities.get(j).getName() + ", Activity duration: " + activities.get(j).getDuration() + ", Activity intensity: " + activities.get(j).getIntensity();
//                    document.add(new Paragraph(activityData));
//                }
//                document.add(new Paragraph(" "));
//            }
//            for(int i=0; i<diets.size(); i++){
//                document.add(new Paragraph("Diet name: " + diets.get(i).getDietName()));
//                List<Food> foods = diets.get(i).getFoods();
//                for(int j=0; j<foods.size(); j++){
//                    String foodData = "Food name: " + foods.get(j).getName() + ", Food prep duration: " + foods.get(j).getDuration() + ", Food calorie count: " + foods.get(j).getCaloriesCount();
//                    document.add(new Paragraph(foodData));
//                }
//                document.add(new Paragraph(" "));
//            }
//            document.close();
//        }catch (FileNotFoundException | DocumentException e){
//            e.printStackTrace();
//        }
//
//    }
//}
