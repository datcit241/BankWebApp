package models;

import data.dao.UserDao;

public class User {
    private String id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String id, String username, String password, String name, String address, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() { return id; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "'" + this.getId() + "'," +
                "'" + this.getUsername() + "'," +
                "'" + this.getPassword() + "'," +
                "'" + this.getName() + "'," +
                "'" + this.getAddress() + "'," +
                "'" + this.getPhoneNumber() + "'";
    }
}
