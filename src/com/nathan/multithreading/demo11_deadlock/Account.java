package com.nathan.multithreading.demo11_deadlock;

/**
 * Created by Nathan on 10/20/2016.
 */
public class Account {

    private int balance = 10000;

    public void desposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.desposit(amount);
    }
}
