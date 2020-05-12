package com.project.reports;

public class ReportFactory {
    public Report getReportType(String reportType){
        if(reportType == null){
            return null;
        }
        if(reportType.equalsIgnoreCase("TextReport")){
            return new TextReport();
        }else if(reportType.equalsIgnoreCase("PdfReport")){
            return new PdfReport();
        }
        return null;
    }
}
