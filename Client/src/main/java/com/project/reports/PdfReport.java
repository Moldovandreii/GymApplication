package com.project.reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.Socket.TransmissionFunc;
import com.project.dao.ActivityDAO;
import com.project.dao.DietDAO;
import com.project.dao.FoodDAO;
import com.project.dao.ProgramDAO;
import javafx.stage.FileChooser;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class PdfReport implements Report{

    @Override
    public void createReport(int trainerId) {
        List<String> namePass = TransmissionFunc.getTrainerNamePass(Integer.toString(trainerId));
        String trainerName = namePass.get(0);
        String trainerPassword = namePass.get(1);
        List<ProgramDAO> programs = TransmissionFunc.getAllPrograms(trainerName, trainerPassword);
        List<DietDAO> diets = TransmissionFunc.getAllDiets(trainerName, trainerPassword);
        Document document = new Document();
        String title = "Report for Trainer with id " + trainerId + ".pdf";
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName(title);
            File file = fileChooser.showSaveDialog(null);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            for(int i=0; i<programs.size(); i++){
                document.add(new Paragraph("Program name: " + programs.get(i).getName()));
                List<ActivityDAO> activities = TransmissionFunc.getProgramActivities(Integer.toString(programs.get(i).getProgramId()));
                for(int j=0; j<activities.size(); j++){
                    String activityData = "Activity name: " + activities.get(j).getName() + ", Activity duration: " + activities.get(j).getDuration() + ", Activity intensity: " + activities.get(j).getIntensity();
                    document.add(new Paragraph(activityData));
                }
                document.add(new Paragraph(" "));
            }
            for(int i=0; i<diets.size(); i++){
                document.add(new Paragraph("Diet name: " + diets.get(i).getDietName()));
                List<FoodDAO> foods = TransmissionFunc.getDietFood(Integer.toString(diets.get(i).getDietId()));
                for(int j=0; j<foods.size(); j++){
                    String foodData = "Food name: " + foods.get(j).getName() + ", Food prep duration: " + foods.get(j).getDuration() + ", Food calorie count: " + foods.get(j).getCaloriesCount();
                    document.add(new Paragraph(foodData));
                }
                document.add(new Paragraph(" "));
            }
            document.close();
        }catch (FileNotFoundException | DocumentException e){
            e.printStackTrace();
        }
    }
}
