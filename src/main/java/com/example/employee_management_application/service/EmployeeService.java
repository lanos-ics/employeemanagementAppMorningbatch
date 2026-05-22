package com.example.employee_management_application.service;

import com.example.employee_management_application.models.Employee;

import java.util.List;

public interface EmployeeService {

    // get all employees method :
    public List<Employee> getEmployees();

    // get 1 employee :
    public Employee getEmployeeById(Long employeeId);

    // add new employee to database :
    public String addEmployee(Employee employee);

}
