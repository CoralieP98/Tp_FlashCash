package com.CoralieP98.FlashCash.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Transfert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user_from;
    @ManyToOne
    private User user_to;

    private double amount_before_fee;
    private double amount_after_fee;

    private Date date;

    public Transfert() {
    }

    public Transfert(int id, User user_from, User user_to, double amount_before_fee, double amount_after_fee, Date date) {
        this.id = id;
        this.user_from = user_from;
        this.user_to = user_to;
        this.amount_before_fee = amount_before_fee;
        this.amount_after_fee = amount_after_fee;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_from() {
        return user_from;
    }

    public void setUser_from(User user_from) {
        this.user_from = user_from;
    }

    public User getUser_to() {
        return user_to;
    }

    public void setUser_to(User user_to) {
        this.user_to = user_to;
    }

    public double getAmount_before_fee() {
        return amount_before_fee;
    }

    public void setAmount_before_fee(double amount_before_fee) {
        this.amount_before_fee = amount_before_fee;
    }

    public double getAmount_after_fee() {
        return amount_after_fee;
    }

    public void setAmount_after_fee(double amount_after_fee) {
        this.amount_after_fee = amount_after_fee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
