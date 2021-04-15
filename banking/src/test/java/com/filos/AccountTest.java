package com.filos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("User should")
class AccountTest {
    private static final String expected = """
            Date        Amount  Balance
            %s   +500      500
            %s   -100      400
            """;

    @ParameterizedTest(name = "deposit = {argumentsWithNames}")
    @ValueSource(ints = { 10, 20, 30, 1000 })
    @DisplayName(" be able to deposit positive amount when")
    void depositPositive(int deposit) {
        Account account = new Account();
        account.deposit(deposit);
        assertThat(account.getBalance()).isEqualTo(deposit);
    }

    @ParameterizedTest(name = "deposit = {argumentsWithNames}")
    @ValueSource(ints = { 0, -10, -20, -30, -1000 })
    @DisplayName("n't be able to deposit negative amount, it should throw InvalidDepositException when")
    void depositNegative(int deposit) {
        Account account = new Account();
        Throwable throwable = catchThrowable(() -> account.deposit(deposit));
        Assertions.assertThat(throwable)
                  .isInstanceOf(InvalidDepositException.class);
    }

    @ParameterizedTest(name = "amount = {argumentsWithNames}")
    @ValueSource(ints = { 10, 20, 100 })
    @DisplayName(" be able to withdraw a positive amount, when has sufficient deposit and")
    void whenUserWithdrawAPositiveAmountItShouldBeCapable(int amount) {
        Account account = new Account();
        account.deposit(200);
        account.withdraw(amount);
        assertThat(account.getBalance()).isEqualTo(200 - amount);
    }

    @ParameterizedTest(name = "deposit = {argumentsWithNames}")
    @ValueSource(ints = { 0, -10, -20, -30, -1000 })
    @DisplayName("n't be able to withdraw a negative amount or doesn't have sufficient deposit, it should throw InvalidDepositException "
            + "when")
    void whenUserWithdrawANegativeAmountItShouldBeCapable(int amount) {
        Account account = new Account();
        account.deposit(200);
        Throwable throwable = catchThrowable(() -> account.withdraw(amount));
        Assertions.assertThat(throwable)
                  .isInstanceOf(InvalidDepositException.class);
    }

    @ParameterizedTest(name = "deposit = {argumentsWithNames}")
    @ValueSource(ints = { 300, 1000 })
    @DisplayName("n't be able to withdraw when doesn't have sufficient deposit, it should throw InvalidDepositException "
            + "when")
    void whenUserWithdrawWhenItDoesntHaveSufficientDeposit(int amount) {
        Account account = new Account();
        account.deposit(200);
        Throwable throwable = catchThrowable(() -> account.withdraw(amount));
        Assertions.assertThat(throwable)
                  .isInstanceOf(InsufficientAmountException.class);
    }

    @Test
    @DisplayName("be able to view the account statement")
    void printStatement() {
        Account account = new Account();
        account.deposit(500);
        account.withdraw(100);
        String statement = account.printStatement();
        assertThat(statement)
                .isEqualTo(expected.formatted(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.M.yyyy")),
                                              LocalDate.now().format(DateTimeFormatter.ofPattern("dd.M.yyyy"))));
    }
}