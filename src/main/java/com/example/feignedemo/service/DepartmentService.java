package com.example.feignedemo.service;

import com.example.feignedemo.feign.EmployeeClient;
import com.example.feignedemo.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final EmployeeClient employeeClient;

    public DepartmentService(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeClient.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    public ResponseEntity<Employee> getEmployeeById(Long id) {
        Employee employee = employeeClient.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    public ResponseEntity<Employee> createEmployee(Employee employee) {
        Employee savedEmployee = employeeClient.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

//    public ResponseEntity<Employee> updateEmployee(Long id, Employee employee) {
//        Employee updatedEmployee = employeeClient.updateEmployee(id, employee);
//        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
//    }

//    public ResponseEntity<Void> deleteEmployee(Long id) {
//        employeeClient.deleteEmployee(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}

