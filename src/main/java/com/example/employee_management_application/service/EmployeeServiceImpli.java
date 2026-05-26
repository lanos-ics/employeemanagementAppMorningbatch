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
    public Employee getEmployeeByName(String employeeName) {
       Employee emp = employeeRepo.findByEmployeeName(employeeName);
       return emp;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Employee emp = employeeRepo.findByEmail(email);
        return emp;
    }

    @Override
    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee added successfully!";
    }

    @Override
    public Employee deleteEmployeeById(Long empId) {

        Optional<Employee> emp = employeeRepo.findById(empId);
        if(emp.isEmpty())
        {
            throw new RuntimeException("Employee does not exists.");
        }

        employeeRepo.deleteById(empId);

        Employee empToReturn = emp.get();

        return empToReturn;
    }

    @Override
    public Employee updateEmployeeById(Long empId,  Employee newEmployee) {
        Optional<Employee> oldEmpData = employeeRepo.findById(empId);
        if(oldEmpData.isEmpty())
        {
            throw new RuntimeException("Employee does not exists.");
        }

        Employee existingEmployee = oldEmpData.get();
        existingEmployee.setEmployeeName(newEmployee.getEmployeeName());
        existingEmployee.setAddress(newEmployee.getAddress());
        existingEmployee.setEmail(newEmployee.getEmail());
        existingEmployee.setSalary(newEmployee.getSalary());
        existingEmployee.setAdharNumber(newEmployee.getAdharNumber());
        existingEmployee.setMobileNumber(newEmployee.getMobileNumber());
        existingEmployee.setPanNumber(newEmployee.getPanNumber());

        employeeRepo.save(existingEmployee);



        return existingEmployee;
    }
}
