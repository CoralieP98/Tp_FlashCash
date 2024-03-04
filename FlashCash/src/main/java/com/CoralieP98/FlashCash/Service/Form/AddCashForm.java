package com.CoralieP98.FlashCash.Service.Form;

import lombok.Data;

@Data
public class AddCashForm {

    private double amount;

    public AddCashForm() {
    }

    public AddCashForm(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
