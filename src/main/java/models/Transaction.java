package models;

import enums.TransactionType;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Transaction {
    public static Comparator<Transaction> transactionByRecentnessComparator;

    static {
        transactionByRecentnessComparator = (transaction1, transaction2) -> -transaction1.getConductedAt().compareTo(transaction2.getConductedAt());
    }

    private String id;
    private String accountId;
    private String toAccountId;
    private TransactionType type;
    private LocalDateTime conductedAt;
    private double prevAmount;
    private double finalAmount;

    public Transaction(String id, String accountId, String toAccountId, TransactionType type, LocalDateTime conductedAt, double prevAmount, double finalAmount) {
        this.id = id;
        this.accountId = accountId;
        this.toAccountId = toAccountId;
        this.type = type;
        this.conductedAt = conductedAt;
        this.prevAmount = prevAmount;
        this.finalAmount = finalAmount;
    }

    public String getId() { return id; }

    public String getAccountId() { return accountId; }

    public String getToAccountId() { return toAccountId; }

    public TransactionType getType() { return type; }

    public LocalDateTime getConductedAt() { return conductedAt; }

    public double getPrevAmount() { return prevAmount; }

    public double getFinalAmount() { return finalAmount; }

    public String getDescription() {
        String description = type + "ed " + (finalAmount - prevAmount);

        if (this.toAccountId != null) {
            description += " to " + this.toAccountId;
        }

        return description;
    }

    @Override
    public String toString() {
        return "'" + this.id + "'," +
                "'" + this.accountId + "'," +
                "'" + this.toAccountId + "'," +
                "'" + this.type.toString() + "'," +
                "'" + Timestamp.valueOf(conductedAt) + "'," +
                this.prevAmount + "," +
                this.finalAmount;
    }
}
