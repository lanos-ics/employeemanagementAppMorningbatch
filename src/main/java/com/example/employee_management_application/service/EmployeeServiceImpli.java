package com.example.employee_management_application.service;

import com.example.employee_management_application.dto.EmployeeDTO;
import com.example.employee_management_application.dto.EmployeeResponseDTO;
import com.example.employee_management_application.exception.EmployeeNotFoundException;
import com.example.employee_management_application.models.Employee;
import com.example.employee_management_application.repo.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpli implements EmployeeService{

    // EmployeRepo is the dependency of impli class :
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;


//    @Override
//    public List<Employee> getEmployees() {
//       List<Employee> employees =  employeeRepo.findAll();
//        return  employees;
//    }

    public EmployeeResponseDTO getEmployees(int pageNumber, int pageSize)
    {
        Pageable pageDetails = PageRequest.of(pageNumber,pageSize);
        Page<Employee> employeePage = employeeRepo.findAll(pageDetails);

       List<EmployeeDTO> convertedEmployee =
               employeePage.stream().map(e ->
                       modelMapper.map(e, EmployeeDTO.class))
                       .toList();

       EmployeeResponseDTO erd = new EmployeeResponseDTO();
       erd.setContent(convertedEmployee);

       return erd;


    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {

       Optional<Employee> emp =  employeeRepo.findById(employeeId);
       if(emp.isEmpty())
       {
           throw new EmployeeNotFoundException("Employee Not Found with ID"+ employeeId);
       }
       Employee realEmployee = emp.get();

       EmployeeDTO empToReturn = modelMapper.map(realEmployee,EmployeeDTO.class);

        return empToReturn;
    }

    @Override
    public EmployeeDTO getEmployeeByName(String employeeName) {
       Employee emp = employeeRepo.findByEmployeeName(employeeName);
       EmployeeDTO empToReturn = modelMapper.map(emp,EmployeeDTO.class);
       return empToReturn;
    }

    @Override
    public EmployeeDTO getEmployeeByEmail(String email) {
        Employee emp = employeeRepo.findByEmail(email);
        EmployeeDTO empToReturn = modelMapper.map(emp,EmployeeDTO.class);
        return empToReturn;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employee) {

        Employee emp = modelMapper.map(employee, Employee.class);

        employeeRepo.save(emp);
        Employee empToReturn = employeeRepo.findById(emp.getId()).orElseThrow(()-> new EmployeeNotFoundException("Employee not found after adding the employee into the database."));
        EmployeeDTO employeeDTO = modelMapper.map(empToReturn, EmployeeDTO.class);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO deleteEmployeeById(Long empId) {

        Optional<Employee> emp = employeeRepo.findById(empId);
        if(emp.isEmpty())
        {
            throw new EmployeeNotFoundException("Employe does not exists to delete by id:"+empId);
        }

        employeeRepo.deleteById(empId);

        Employee empToReturn = emp.get();
        EmployeeDTO employeeDTO = modelMapper.map(empToReturn,EmployeeDTO.class);

        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployeeById(Long empId,  EmployeeDTO newEmployee) {
        Optional<Employee> oldEmpData = employeeRepo.findById(empId); // old emp repo se nikala
        if(oldEmpData.isEmpty())
        {
            throw new EmployeeNotFoundException("Employee not found to update by id : "+ empId);
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
        EmployeeDTO empToReturn = modelMapper.map(existingEmployee,EmployeeDTO.class);


        return empToReturn;
    }
}
