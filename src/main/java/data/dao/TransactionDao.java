package data.dao;

import data.database_management.DatabaseManagement;
import enums.TransactionType;
import models.Transaction;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao implements DaoInterface<Transaction> {
    private DatabaseManagement databaseManagement;

    public TransactionDao() {
        databaseManagement = DatabaseManagement.getDatabaseManagement();
    }

    @Override
    public List<Transaction> get() {
        List<Transaction> list = new ArrayList<>();
        String query = "select * from transactions";
        try {
            ResultSet rs = databaseManagement.doExecuteQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                String accountId = rs.getString("account_id");
                String toAccountId = rs.getString("to_account_id");
                TransactionType type = TransactionType.valueOf(rs.getString("type"));
                LocalDate savedFrom = new Date(rs.getDate("saved_from").getTime()).toLocalDate();
                double prevAmount = rs.getDouble("prev_amount");
                double finalAmount = rs.getDouble("final_amount");

                Transaction transaction = new Transaction(id, accountId, toAccountId, type, savedFrom, prevAmount, finalAmount);
                list.add(transaction);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public void insert(Transaction transaction) {
        String query = "insert into accounts values(" + transaction + ")";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Transaction transaction) {

    }

    @Override
    public void update(Transaction transaction) {

    }
}