package com.example.SpringEmployeePayrollApp.controller;

import com.example.SpringEmployeePayrollApp.dto.EmployeeDTO;
import com.example.SpringEmployeePayrollApp.entity.Employee;
import com.example.SpringEmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Sec1 UC1
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Sec1 UC2
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    // Sec2 UC1
    @PostMapping("/dto")
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    // Sec2 UC2
    @GetMapping("/fetch")
    public List<Employee> fetchAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    // Sec2 UC3
    @GetMapping("/memory")
    public List<Employee> getAllEmployeesFromMemory() {
        return employeeService.getAllEmployeesFromMemory();
    }

    @GetMapping("/memory/{id}")
    public Optional<Employee> getEmployeeByIdFromMemory(@PathVariable Long id) {
        return employeeService.getEmployeeByIdFromMemory(id);
    }

}
