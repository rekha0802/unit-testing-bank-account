package com.rekha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void saldoAwalNol() {
        BankAccount account = new BankAccount();
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void depositBerhasil() {
        BankAccount account = new BankAccount();
        account.deposit(100000);
        assertEquals(100000, account.getBalance());
    }

    @Test
    void depositBertambah() {
        BankAccount account = new BankAccount();
        account.deposit(100000);
        account.deposit(50000);
        assertEquals(150000, account.getBalance());
    }

    @Test
    void depositNegatifDitolak() {
        BankAccount account = new BankAccount();
        assertThrows(IllegalArgumentException.class,
            () -> account.deposit(-10000));
    }

    @Test
    void withdrawBerhasil() {
        BankAccount account = new BankAccount();
        account.deposit(100000);
        account.withdraw(30000);
        assertEquals(70000, account.getBalance());
    }

    @Test
    void withdrawMelebihiSaldoDitolak() {
        BankAccount account = new BankAccount();
        account.deposit(50000);
        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(100000));
    }

    @Test
    void withdrawNegatifDitolak() {
        BankAccount account = new BankAccount();
        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(-10000));
    }

    @Test
    void withdrawSeluruhSaldo() {
        BankAccount account = new BankAccount();
        account.deposit(50000);
        account.withdraw(50000);
        assertEquals(0.0, account.getBalance());
    }
}
