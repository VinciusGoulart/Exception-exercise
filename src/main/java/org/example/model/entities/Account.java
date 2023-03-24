package org.example.model.entities;

import org.example.model.exceptions.DomainException;

public class Account {

    private String number;
    private String holder;
    private Double balance = 0.00;
    private Double withdrawLimit;

    public Account() {

    }

    public Account(String number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) throws DomainException {
        if (amount > withdrawLimit) {
            throw new DomainException("The amount exceeds withdraw limit.");
        } else if (amount > balance) {
            throw new DomainException("Not enough balance");
        } else {
            balance -= amount;
        }

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account data: ").append("\n");
        sb.append("Number: ").append(number);
        sb.append("\nHolder: ").append(holder);
        sb.append(String.format("%nBalance: $%.2f%n", balance));
        sb.append(String.format("Withdraw limit: $%.2f%n", withdrawLimit));
        return sb.toString();
    }
}
