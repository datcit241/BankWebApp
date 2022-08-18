package services;


import data.DataStorage;
import data.dao.NewUserDao;
import data.dao.UserDao;
import models.User;

import java.util.Random;
import java.util.UUID;

public class UserService {
    private DataStorage dataStorage;

    public UserService() {
        dataStorage = DataStorage.getDataStorage();
    }

    public User getUserWithUsername(String username) {
        return dataStorage.getUserRepository().find(user -> user.getUsername().equals(username));
    }

    public String createUser() {
        String username;
        while (getUserWithUsername(username = String.format("%09d", new Random().nextLong())) != null);
        String password = UUID.randomUUID().toString();

        createUser(username, password);

        User user = getUserWithUsername(username);

        return username;
    }

    public boolean createUser(String username, String password) {
        User user = dataStorage.getUserRepository().find(anyUser -> anyUser.getUsername().equals(username));
        if (user != null) {
            return false;
        }

        String id = UUID.randomUUID().toString();
        user = new User(id, username, password);
        new UserDao().insert(user);
        new NewUserDao().insert(user.getId());

        return true;
    }

    public boolean isNewUser(User user) {
        String id = dataStorage.getNewUserRepository().find(anyId -> user.getId().equals(anyId));
        return id != null;
    }

    public void activate(User user) {
        new NewUserDao().delete(user.getId());
        new AccountService().createAccounts(user);
    }

    public boolean login(String username, String password) {
        User user = dataStorage.getUserRepository().find(anyUser -> anyUser.getUsername().equals(username));

        if (user == null) {
            return false;
        }

        return user.getPassword().equals(password);
    }

}
