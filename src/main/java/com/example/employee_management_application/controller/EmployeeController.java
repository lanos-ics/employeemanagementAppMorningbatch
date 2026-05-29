package com.example.employee_management_application.controller;
import com.example.employee_management_application.models.Employee;
import com.example.employee_management_application.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Employee>> getEmployees()
    {
      List<Employee> employees =  employeeService.getEmployees();
      return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("api/v1/employees/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId)
    {
       Employee emp =  employeeService.getEmployeeById(empId);
       return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @GetMapping("api/v1/emp/")
    public ResponseEntity<Employee> getEmployeeByName(@RequestParam(name = "en") String empName)
    {
        Employee emp =  employeeService.getEmployeeByName(empName);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @GetMapping("/api/v1/employees/")
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam(name = "em") String empEmail){

        Employee e = employeeService.getEmployeeByEmail(empEmail);
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }
    // add/create employee :
    @PostMapping("api/v1/employees")
    public ResponseEntity<String> addEmployee( @Valid @RequestBody Employee employee )
    {
        String message = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @DeleteMapping("api/v1/admin/employees/{empId}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Long empId)
    {
       Employee emp =  employeeService.deleteEmployeeById(empId);
       return ResponseEntity.status(HttpStatus.OK).body(emp);
    }
    @PutMapping("api/v1/admin/employees/{empId}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Long empId, @RequestBody Employee employee)
    {
       Employee emp =  employeeService.updateEmployeeById(empId, employee);
       return ResponseEntity.ok().body(emp);
    }


}
