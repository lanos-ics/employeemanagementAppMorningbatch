package com.example.employee_management_application.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestemp;
    private int status;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDateTime timestemp, int status, String message) {
        this.timestemp = timestemp;
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getTimestemp() {
        return timestemp;
    }

    public void setTimestemp(LocalDateTime timestemp) {
        this.timestemp = timestemp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
