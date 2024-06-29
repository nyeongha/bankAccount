package test;

import domain.Account;
import domain.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BankTest {
    private Bank bank;

    @BeforeEach
    @Test
    void setUp() {
        bank = new Bank();
    }

    @Test
    void testGetTotalAccount_WithAccounts() {
        bank.addAccount("12345", "Alice");
        bank.addAccount("67890", "Bob");

        int total = bank.getTotalAccount();
        assertEquals(2, total);
    }

    @Test
    void testFindAccounts_AccountExists() {
        bank.addAccount("12345", "Alice");
        bank.addAccount("67890", "Alice");
        bank.addAccount("11223", "Bob");

        Optional<List<Account>> result = bank.findAccounts("Alice");

        assertEquals(2, result.get().size());
    }

    @Test
    void testGetAccount_AccountDoesNotExist() {
        Optional<Account> account = bank.getAccount("99999");
        Assertions.assertTrue(account.isEmpty());
    }

    @Test
    void testFindAccounts_EmptyBank() {
        Optional<List<Account>> result = bank.findAccounts("Alice");
        Assertions.assertTrue(result.isEmpty());

    }

    @Test
    void testGetAccount_AccountExists() {
        bank.addAccount("12345", "Alice");
        Optional<Account> account = bank.getAccount("12345");

        Assertions.assertTrue(account.isPresent());
        assertEquals("12345", account.get().getAccountNo(), "Expected account number to be 12345");
    }





}