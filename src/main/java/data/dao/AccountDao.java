package data.dao;

import data.database_management.DatabaseManagement;
import enums.AccountType;
import models.Account;

import java.sql.ResultSet;
import java.util.*;

public class AccountDao implements DaoInterface<Account> {
    private DatabaseManagement databaseManagement;

    public AccountDao() {
        this.databaseManagement = DatabaseManagement.getDatabaseManagement();
    }
    @Override
    public List<Account> get() {
        List<Account> list = new ArrayList<>();
        String query = "select * from accounts";
        try {
            ResultSet rs = databaseManagement.doExecuteQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                String userId = rs.getString("user_id");
                double balance = rs.getDouble("balance");
                AccountType type = AccountType.valueOf(rs.getString("type"));

                Account account = new Account(id, userId, balance, type);
                list.add(account);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(query);
        }

        return list;
    }

    @Override
    public void insert(Account account) {
        String query = "insert into accounts values(" + account + ")";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public void update(Account account) {
        String query = "update accounts set " +
                "balance = " + account.getBalance() + "," +
                "type = '" + account.getType().toString() + "' " +
                "where id = '" + account.getId() + "'";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(query);
        }
    }
}
