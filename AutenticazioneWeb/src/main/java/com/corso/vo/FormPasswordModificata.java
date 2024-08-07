package com.corso.vo;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class FormPasswordModificata {

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La password deve avere almeno 8 caratteri e contenere almeno una lettera maiuscola, una minuscola, un numero e un carattere speciale")
    private String password;

    @NotEmpty()
    private String confermaPassword;

    @AssertTrue(message = "Le password non corrispondono")
    private boolean isValidPassword() {
        return password.equals(confermaPassword);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfermaPassword() {
        return confermaPassword;
    }

    public void setConfermaPassword(String confermaPassword) {
        this.confermaPassword = confermaPassword;
    }

    @Override
    public String toString() {
        return "FormPasswordModificata{" +
                ", password='" + password + '\'' +
                ", confermaPassword='" + confermaPassword + '\'' +
                '}';
    }
}
