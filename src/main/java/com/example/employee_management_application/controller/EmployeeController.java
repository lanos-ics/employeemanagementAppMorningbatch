package com.example.employee_management_application.controller;
import com.example.employee_management_application.dto.EmployeeDTO;
import com.example.employee_management_application.dto.EmployeeResponseDTO;
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
    public ResponseEntity<EmployeeResponseDTO> getEmployees(
          @RequestParam(name = "pn")  int pageNumber,
          @RequestParam(name = "ps")  int pageSize
    )
    {
        EmployeeResponseDTO employees =  employeeService.getEmployees(pageNumber, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("api/v1/employees/{empId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long empId)
    {
        EmployeeDTO emp =  employeeService.getEmployeeById(empId);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @GetMapping("api/v1/emp/")
    public ResponseEntity<EmployeeDTO> getEmployeeByName(@RequestParam(name = "en") String empName)
    {
        EmployeeDTO emp =  employeeService.getEmployeeByName(empName);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @GetMapping("/api/v1/employees/")
    public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@RequestParam(name = "em") String empEmail){

        EmployeeDTO e = employeeService.getEmployeeByEmail(empEmail);
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }
    // add/create employee :
    @PostMapping("api/v1/employees")
    public ResponseEntity<EmployeeDTO> addEmployee( @Valid @RequestBody EmployeeDTO employee )
    {
        EmployeeDTO employeeDTO = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
    }

    @DeleteMapping("api/v1/admin/employees/{empId}")
    public ResponseEntity<EmployeeDTO> deleteEmployeeById(@PathVariable Long empId)
    {
        EmployeeDTO emp =  employeeService.deleteEmployeeById(empId);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }
    @PutMapping("api/v1/admin/employees/{empId}")
    public ResponseEntity<EmployeeDTO> deleteEmployeeById(@PathVariable Long empId, @RequestBody EmployeeDTO employee)
    {
        EmployeeDTO emp =  employeeService.updateEmployeeById(empId, employee);
        return ResponseEntity.ok().body(emp);
    }


}
