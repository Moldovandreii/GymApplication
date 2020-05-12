//package com.project.reports;
//
//import com.project.services.*;
//
//public class ReportFactory {
//    public Report getReportType(String reportType, TrainerService trainerService, ProgramService programService, DietService dietService){
//        if(reportType == null){
//            return null;
//        }
//        if(reportType.equalsIgnoreCase("TextReport")){
//            return new TextReport(trainerService, programService, dietService);
//        }else if(reportType.equalsIgnoreCase("PdfReport")){
//            return new PdfReport(trainerService, programService, dietService);
//        }
//        return null;
//    }
//}
