package com.example.SpringEmployeePayrollApp.service;

import com.example.SpringEmployeePayrollApp.dto.EmployeeDTO;
import com.example.SpringEmployeePayrollApp.entity.Employee;
import com.example.SpringEmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> employeeMemoryStore = new ArrayList<>(); // In-memory storage

    // Section1 UC1
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        employeeMemoryStore.add(employee); // Store in memory
        return employeeRepository.save(employee); // Store in DB
    }

    // Sec1 UC2
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setDepartment(updatedEmployee.getDepartment());
                    employee.setSalary(updatedEmployee.getSalary());
                    return employeeRepository.save(employee);
                })
                .orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeMemoryStore.removeIf(emp -> emp.getId().equals(id)); // Remove from memory
        employeeRepository.deleteById(id); // Remove from DB
    }

    // Sec2 UC1
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employeeMemoryStore.add(employee); // Store in memory
        return employeeRepository.save(employee); // Store in DB
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Sec2 UC2
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    // Sec2 UC3
    public List<Employee> getAllEmployeesFromMemory() {
        return new ArrayList<>(employeeMemoryStore);
    }

    public Optional<Employee> getEmployeeByIdFromMemory(Long id) {
        return employeeMemoryStore.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }
}
