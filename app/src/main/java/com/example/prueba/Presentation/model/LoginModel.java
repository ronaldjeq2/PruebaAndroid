package com.example.prueba.Presentation.model;

import com.example.prueba.Data.LoginResponse;

public class LoginModel implements Login {
    Boolean success;
    String message;

    public LoginModel(LoginResponse loginResponse) {
        this.success = loginResponse.getSuccess();
        this.message = loginResponse.getMessage();
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
