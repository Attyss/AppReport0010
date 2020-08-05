package com.amorettyss.report.entity;
//create an JPA is imperativ and important for die functionality of the
//app development with Spring. it configure the connection with the db
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="employee") //set the exactly name of the table
public class Jpa_Employees implements Serializable {

    @Id
    private int id;         //set the exactly name of the variable
    private String name;
    private String designation;
    private String salary;
    private String doj;

    private static final long serialVersionUID = 1l;

    //here are the standard methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

