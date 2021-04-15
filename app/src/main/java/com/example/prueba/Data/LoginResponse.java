package com.example.prueba.Data;

public class LoginResponse {
    private Boolean success;
    private String message;

    private LoginResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
