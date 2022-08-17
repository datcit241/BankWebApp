package data.dao;

import data.database_management.DatabaseManagement;

import java.sql.ResultSet;
import java.util.*;

public class NewUserDao implements DaoInterface<String> {
    private DatabaseManagement databaseManagement;

    public NewUserDao() {
        this.databaseManagement = DatabaseManagement.getDatabaseManagement();
    }

    @Override
    public List<String> get() {
        List<String> list = new ArrayList<>();
        String query = "select * from new_users";
        try {
            ResultSet rs = databaseManagement.doExecuteQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                list.add(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public void insert(String s) {
        String query = "insert into new_users values('" + s + "')";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String s) {
        String query = "delete from new_users where id = '" + s + "'";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String s) {

    }
}
