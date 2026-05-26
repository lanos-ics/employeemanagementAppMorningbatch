package com.example.employee_management_application.repo;

import com.example.employee_management_application.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    public Employee findByEmployeeName(String employeeName);
    public Employee findByEmail(String email);

}
