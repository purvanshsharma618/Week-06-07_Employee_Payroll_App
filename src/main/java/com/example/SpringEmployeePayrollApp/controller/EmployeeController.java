package com.example.SpringEmployeePayrollApp.controller;

import com.example.SpringEmployeePayrollApp.model.EmployeeModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    //UC1
    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    @PostMapping("/add")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employee) {
        return employee;  // Temporary response (No DB yet)
    }
}