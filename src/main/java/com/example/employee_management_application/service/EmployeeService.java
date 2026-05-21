package com.example.employee_management_application.service;

import com.example.employee_management_application.models.Employee;

import java.util.List;

public interface EmployeeService {

    // get all employees method :
    public List<Employee> getEmployees();

    // add new employee to database :
    public String addEmployee(Employee employee);

}
