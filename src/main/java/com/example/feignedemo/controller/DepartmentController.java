package com.example.feignedemo.controller;
import com.example.feignedemo.model.Employee;
import com.example.feignedemo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feignClient")
public class DepartmentController
{
    private final DepartmentService departmentService;
    private DepartmentController employeeClient;

    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return departmentService.getEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return departmentService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return departmentService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        departmentService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted with id " + id);
    }

}
