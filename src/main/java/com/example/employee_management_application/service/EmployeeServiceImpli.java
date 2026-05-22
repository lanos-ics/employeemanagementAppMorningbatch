package com.example.employee_management_application.service;

import com.example.employee_management_application.models.Employee;
import com.example.employee_management_application.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Employee getEmployeeById(Long employeeId) {

       Optional<Employee> emp =  employeeRepo.findById(employeeId);
       if(emp.isEmpty())
       {
           throw new RuntimeException("Employee does not exists with is " + employeeId + " .");
       }
       Employee realEmployee = emp.get();
        return realEmployee;
    }

    @Override
    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee added successfully!";
    }
}
