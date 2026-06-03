package com.example.employee_management_application.dto;

import java.util.List;

public class EmployeeResponseDTO {

    private List<EmployeeDTO> content;

    public EmployeeResponseDTO() {
    }

    public EmployeeResponseDTO(List<EmployeeDTO> content) {
        this.content = content;
    }

    public List<EmployeeDTO> getContent() {
        return content;
    }

    public void setContent(List<EmployeeDTO> content) {
        this.content = content;
    }
}
