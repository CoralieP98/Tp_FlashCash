package com.CoralieP98.FlashCash.Service.Form;

public class WithdrawCashForm {


    private double amount;

    public WithdrawCashForm() {
    }

    public WithdrawCashForm(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
