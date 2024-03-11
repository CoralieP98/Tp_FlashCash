package com.CoralieP98.FlashCash.Service.Form;

import lombok.Data;

@Data
public class ContactForm {

    private String lastName;
    private String email;

    private String message;

    public ContactForm() {
    }

    public ContactForm(String lastName, String email, String message) {
        this.lastName = lastName;
        this.email = email;
        this.message = message;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
