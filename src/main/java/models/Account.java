package models;

import enums.AccountType;

public class Account {
    private String id;
    private String userId;
    private double balance;
    private AccountType type;

    public Account(String id, String userId, double balance, AccountType type) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.type = type;
    }

    public String getId() { return id; }

    public String getUserId() { return userId; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public void updateBalance(double amount) { this.balance += amount; }

    public AccountType getType() { return type; }
    public void setType(AccountType type) { this.type = type; }

    @Override
    public String toString() {
        return "'" + this.id + "'," +
                "'" + this.userId + "'," +
                this.balance + "," +
                "'" + this.type + "'";
    }
}
