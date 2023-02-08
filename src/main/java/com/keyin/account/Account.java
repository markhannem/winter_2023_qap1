package com.keyin.account;

public class Account {
    private String id;
    private String name;
    private int balance = 0;

    // Constructor 1
    public Account(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    // Constructor 2
    public Account(String id, String name,int balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        return (this.balance += amount);
    }

    public int debit(int amount) {
        if (amount <= this.balance) {
            balance = balance - amount;
        }
        else {
            System.out.println("Amount exceeded balance");
        }
        return(balance);
    }

    public void transferTo(int amount, Account destAcc)
    {
        if (amount <= this.balance) {
            this.debit(amount);
            destAcc.credit(amount);
        }
        else {
            System.out.println("Amount exceeded balance");
        }
    }

    public String toString() {
        return "Account Id: " + this.id + "Name: " + this.name + "Account Balance" + this.balance;
    }
}
