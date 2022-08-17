package data;

import data.dao.*;
import data.repositories.Repository;
import models.Account;
import models.SavingAccountDetails;
import models.Transaction;
import models.User;

public class DataStorage {
    private static DataStorage dataStorage;
    private Repository<User> userRepository;
    private Repository<Account> accountRepository;
    private Repository<SavingAccountDetails> savingAccountDetailsRepository;
    private Repository<String> newUserRepository;
    private Repository<Transaction> transactionRepository;

    private DataStorage() {
        this.userRepository = new Repository<>(new UserDao());
        this.accountRepository = new Repository<>(new AccountDao());
        this.savingAccountDetailsRepository = new Repository<>(new SavingAccountDao());
        this.newUserRepository = new Repository<>(new NewUserDao());
        this.transactionRepository = new Repository<>(new TransactionDao());
    }

    public static DataStorage getDataStorage() {
        if (dataStorage == null) {
            dataStorage = new DataStorage();
        }
        return dataStorage;
    }

    public Repository<User> getUserRepository() { return this.userRepository; }
    public Repository<Account> getAccountRepository() { return this.accountRepository; }
    public Repository<SavingAccountDetails> getSavingAccountDetailsRepository() { return savingAccountDetailsRepository; }
    public Repository<String> getNewUserRepository() { return newUserRepository; }
    public Repository<Transaction> getTransactionRepository() { return transactionRepository; }

}
