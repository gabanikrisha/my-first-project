package com.example.feignedemo.feign;

import com.example.feignedemo.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "employee-service", url = "http://localhost:8085")
public interface EmployeeClient
{

    @GetMapping("/employee")
    List<Employee> getAllEmployees();

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable("id") Long id);

    @PostMapping("/employee")
    Employee createEmployee(@RequestBody Employee employee);

    @PutMapping("/employee/{id}")
    Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee);

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable("id") Long id);

}
