package com.example.employee_management_application.controller;

import com.example.employee_management_application.models.Employee;
import com.example.employee_management_application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    // service interface is dependency for EmployeeController:
    @Autowired
    private EmployeeService employeeService;

    // get employees :

    @GetMapping("api/v1/employees")
    public List<Employee> getEmployees()
    {
      List<Employee> employees =  employeeService.getEmployees();
      return employees;
    }

    // add/create employee :
    @PostMapping("api/v1/employee")
    public String addEmployee(@RequestBody Employee employee )
    {
        String message = employeeService.addEmployee(employee);
        return message;
    }

}
