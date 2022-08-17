package data.dao;

import data.database_management.DatabaseManagement;
import models.SavingAccountDetails;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SavingAccountDao implements DaoInterface<SavingAccountDetails> {
    private DatabaseManagement databaseManagement;

    public SavingAccountDao() {
        this.databaseManagement = DatabaseManagement.getDatabaseManagement();
    }
    @Override
    public List<SavingAccountDetails> get() {
        List<SavingAccountDetails> list = new ArrayList<>();
        String query = "select * from saving_accounts";
        try {
            ResultSet rs = databaseManagement.doExecuteQuery(query);
            while (rs.next()) {
                String accountId = rs.getString("account_id");
                LocalDate savedFrom = new Date(rs.getDate("saved_from").getTime()).toLocalDate();
                String savingPlanId = rs.getString("plan_id");

                SavingAccountDetails savingAccountDetails = new SavingAccountDetails(accountId, savedFrom, savingPlanId);
                list.add(savingAccountDetails);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public void insert(SavingAccountDetails savingAccountDetails) {
        String query = "insert into accounts values(" + savingAccountDetails + ")";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(SavingAccountDetails savingAccountDetails) {

    }

    @Override
    public void update(SavingAccountDetails savingAccountDetails) {
        String query = "update accounts set" +
                "saved_from = '" + savingAccountDetails.getSavedFrom() + "'," +
                "saving_plan_id = '" + savingAccountDetails.getSavingPlanId() + "'";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
