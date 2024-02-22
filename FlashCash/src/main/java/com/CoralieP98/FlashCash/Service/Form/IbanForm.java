package com.CoralieP98.FlashCash.Service.Form;

import lombok.Data;

@Data
public class IbanForm {

    private String iban1;

    public IbanForm() {
    }

    public IbanForm(String iban1) {
        this.iban1 = iban1;
    }

    public String getIban1() {
        return iban1;
    }

    public void setIban1(String iban1) {
        this.iban1 = iban1;
    }
}
