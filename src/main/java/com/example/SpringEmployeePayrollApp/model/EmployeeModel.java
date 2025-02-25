package com.example.SpringEmployeePayrollApp.model;

public class EmployeeModel {
    private String name;
    private double salary;

    EmployeeModel(){}

    public EmployeeModel(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}