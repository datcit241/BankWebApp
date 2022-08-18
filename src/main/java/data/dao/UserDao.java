package data.dao;

import data.database_management.DatabaseManagement;
import models.User;

import java.sql.*;
import java.util.*;

public class UserDao implements DaoInterface<User> {
    private DatabaseManagement databaseManagement = DatabaseManagement.getDatabaseManagement();

    @Override
    public List<User> get() {
        List<User> list = new ArrayList<>();
        String query = "select * from users";
        try {
            ResultSet rs = databaseManagement.doExecuteQuery(query);
            while (rs.next()) {
                String userId = rs.getString("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");

                User user = new User(userId, username, password, name, address, phoneNumber);
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public void insert(User user) {
        String query = "insert into users values(" + user + ")";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {
        String query = "update users set" +
                "password = '" + user.getPassword() + "'," +
                "name = '" + user.getName() + "'," +
                "address = '" + user.getAddress() + "'," +
                "phone_number = '" + user.getPhoneNumber() + "'," +
                "where id = '" + user.getId() + "'";
        try {
            databaseManagement.doExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
