package com.filos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class Account {
    private final List<Operation> operations;
    @Getter
    private int balance;

    public Account() {
        operations = new ArrayList<>();
    }

    public void deposit(int amount) {
        checkPositive(amount);
        operations.add(Operation.from(LocalDate.now(), amount, balance + amount));
        balance += amount;
    }

    public void withdraw(int amount) {
        checkPositive(amount);
        if (balance < amount) {
            throw new InsufficientAmountException();
        } else {
            operations.add(Operation.from(LocalDate.now(), -amount, balance - amount));
            balance -= amount;
        }
    }

    public String printStatement() {
        StringBuilder builder = new StringBuilder();
        builder.append("Date        Amount  Balance\n");
        operations.forEach(operation -> builder.append(operation.toString()));
        return builder.toString();
    }

    private void checkPositive(int value) {
        if (value <= 0)
            throw new InvalidDepositException();
    }
}
