package com.example.employee_management_application.service;

import com.example.employee_management_application.models.Employee;
import com.example.employee_management_application.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpli implements EmployeeService{

    // EmployeRepo is the dependency of impli class :
    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public List<Employee> getEmployees() {
       List<Employee> employees =  employeeRepo.findAll();
        return  employees;
    }

    @Override
    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee added successfully!";
    }
}
