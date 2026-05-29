package com.example.employee_management_application.controller;
import com.example.employee_management_application.models.Employee;
import com.example.employee_management_application.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    // service interface is dependency for EmployeeController:
    @Autowired
    private EmployeeService employeeService;

    // get employees :

    @GetMapping("api/v1/employee")
    public List<Employee> getEmployees()
    {
      List<Employee> employees =  employeeService.getEmployees();
      return employees;
    }

    @GetMapping("api/v1/employees/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId)
    {
       Employee emp =  employeeService.getEmployeeById(empId);
       return emp;
    }

    @GetMapping("api/v1/emp/")
    public Employee getEmployeeByName(@RequestParam(name = "en") String empName)
    {
        Employee emp =  employeeService.getEmployeeByName(empName);
        return emp;
    }

    @GetMapping("/api/v1/employees/")
    public Employee getEmployeeByEmail(@RequestParam(name = "em") String empEmail){

        Employee e = employeeService.getEmployeeByEmail(empEmail);
        return e;
    }
    // add/create employee :
    @PostMapping("api/v1/employees")
    public String addEmployee( @Valid @RequestBody Employee employee )
    {
        String message = employeeService.addEmployee(employee);
        return message;
    }

    @DeleteMapping("api/v1/admin/employees/{empId}")
    public Employee deleteEmployeeById(@PathVariable Long empId)
    {
       Employee emp =  employeeService.deleteEmployeeById(empId);
       return emp;
    }
    @PutMapping("api/v1/admin/employees/{empId}")
    public Employee deleteEmployeeById(@PathVariable Long empId, @RequestBody Employee employee)
    {
       Employee emp =  employeeService.updateEmployeeById(empId, employee);
       return emp;
    }


}
