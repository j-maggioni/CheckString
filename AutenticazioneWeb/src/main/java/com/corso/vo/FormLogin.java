package com.corso.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class FormLogin {

    @NotEmpty(message="Accesso non eseguito! Inserire una e-mail valida")
    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$",
            message="Accesso non eseguito! Inserire una e-mail valida")
    private String email;

    @NotEmpty(message="Accesso non eseguito! Inserire una password valida")
    private String password;

    private String globalError;

    public FormLogin() {}

    public FormLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGlobalError() {
        return globalError;
    }

    public void setGlobalError(String globalError) {
        this.globalError = globalError;
    }
}
