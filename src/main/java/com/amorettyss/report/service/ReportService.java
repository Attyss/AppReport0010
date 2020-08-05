package com.amorettyss.report.service;

import com.amorettyss.report.entity.Jpa_Employees;
import com.amorettyss.report.repository.ReportRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SocketUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository; //load ind pick and keep up the dataResource of the db

    public String report(String reportFormat) throws FileNotFoundException, JRException {
        List<Jpa_Employees> employees = repository.findAll();
        //load and compile all the file of repository and put on the employees List and insert this in the jasper templates
        File file = ResourceUtils.getFile("classpath:\\templates\\listEmployees.jrxml"); //"classpath:employees.jrxml"
        JasperReport jasperR = JasperCompileManager.compileReport(file.getPath());
        JRBeanCollectionDataSource dataResource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Amorettyss");
        JasperPrint printJ = JasperFillManager.fillReport(jasperR, parameters, dataResource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(printJ,"C:\\Users\\User1\\Desktop\\Report\\employeesReport.html");
        }else if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(printJ,"C:\\Users\\User1\\Desktop\\Report\\employeesReport.pdf");
        }else{
         return "Sorry! The report could did not be created";
        }
        return "EUREKAAAA! Eureka, your report will be created and save in you submit path" ;
    }
}
