package com.amorettyss.report.repository;

import com.amorettyss.report.entity.Jpa_Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends JpaRepository <Jpa_Employees, Integer> {  //extends CrudRepository ist oder options
}
