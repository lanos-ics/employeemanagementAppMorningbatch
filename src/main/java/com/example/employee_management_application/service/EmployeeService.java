package com.example.employee_management_application.service;

import com.example.employee_management_application.dto.EmployeeDTO;
import com.example.employee_management_application.dto.EmployeeResponseDTO;
import com.example.employee_management_application.models.Employee;

import java.util.List;

public interface EmployeeService {

    // get all employees method :
    public EmployeeResponseDTO getEmployees();

    // get 1 employee :
    public EmployeeDTO getEmployeeById(Long employeeId);

    public EmployeeDTO getEmployeeByName(String employeeName);

    public EmployeeDTO getEmployeeByEmail(String email);

    // add new employee to database :
    public EmployeeDTO addEmployee(EmployeeDTO employee);

    public EmployeeDTO deleteEmployeeById(Long empId);

    public EmployeeDTO updateEmployeeById(Long empId, EmployeeDTO newEmployee);

}
