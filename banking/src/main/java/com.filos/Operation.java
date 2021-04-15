package com.filos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "from")
@Getter
class Operation {
    private final LocalDate dateOfExecution;
    private final int amount;
    private final int balance;

    @Override
    public String toString() {
        return prettyFormatDate() + "   " + prettyAmount() + "      " + balance + "\n";
    }

    private String prettyAmount() {
        return amount == 0 ? "0" : (amount > 0 ? "+" : "") + amount;
    }

    private String prettyFormatDate() {
        return dateOfExecution.format(DateTimeFormatter.ofPattern("dd.M.yyyy"));
    }
}
