package com.amorettyss.report;

import com.amorettyss.report.entity.Jpa_Employees;
import com.amorettyss.report.repository.ReportRepository;
import com.amorettyss.report.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@SpringBootApplication
public class AppReportApplication { //implements CommandLineRunner

    @Autowired
    private ReportRepository repository;

    @Autowired
    private ReportService service;

    //Mapping methods 1
    @RequestMapping(value= "/sayHallo", method = RequestMethod.GET)
    public String sayHallo () {
        return "Hi! i am here!";
    }
    //Mapping methods 2
    @GetMapping("/getText")
    public String getText() {
        return "Hi! i am Here and i will be mapped with annotation @getMapping";
    }
    //with it you can check the connection with the db. If this not work, you have to check .properties and Jpa.
    @GetMapping("/getTable")
    public List<Jpa_Employees> getTable_employee() {
        return repository.findAll();
    }
    //tape in the webbrowser: http://localhost:youPort/report/pdf  or /report/html
    @GetMapping("/report/{format}")
    public String generationJasperReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.report(format);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppReportApplication.class, args);
    }

}
