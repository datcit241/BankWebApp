package services;

import data.*;
import data.dao.*;
import enums.*;
import models.*;
import utilities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AccountService {
    private static final int MIN_BALANCE = 10_000_000;
    private static final int CHARGE = 50_000;
    private static InterestCalculator interestCalculator;

    private DataStorage dataStorage;
    private AccountDao accountDao;

    public AccountService() {
        dataStorage = DataStorage.getDataStorage();
        interestCalculator = new CompoundInterestCalculator(SavingPlan.getDefaultSavingPlan());
        accountDao = new AccountDao();
    }

    public Account getUserAccount(User user, AccountType accountType) {
        Account account = dataStorage.getAccountRepository().find(anyAccount -> anyAccount.getUserId().equals(user.getId()) && anyAccount.getType() == accountType);
        return account;
    }

    public Account getAccountById(String id) {
        Account account = dataStorage.getAccountRepository().find(anyAccount -> anyAccount.getId().equals(id));
        return account;
    }

    public boolean createAccounts(User user) {
        boolean flag1 = createAccount(user, AccountType.Current);
        boolean flag2 = createAccount(user, AccountType.Saving);
        return flag1 && flag2;
    }

    public boolean createAccount(User user, AccountType accountType) {
        String id = UUID.randomUUID().toString();
        Account account = new Account(id, user.getId(), 0d, accountType);

        new AccountDao().insert(account);
        return true;
    }

    public SavingAccountDetails getSavingAccountDetails(Account account) {
        SavingAccountDetails savingAccountDetails = dataStorage.getSavingAccountDetailsRepository().find(savingAccount -> savingAccount.getAccountId().equals(account.getId()));
        return savingAccountDetails;
    }

    public void changePlan(Account account) {
        if (account.getType() == AccountType.Saving) {
            SavingAccountDetails savingAccountDetails = getSavingAccountDetails(account);
            if (interestCalculator instanceof CompoundInterestCalculator) {
                ((CompoundInterestCalculator) interestCalculator).setSavingPlan(SavingPlan.getDefaultSavingPlan());
            }
        }
    }

    public double getBalance(Account account) {
        if (account.getType() == AccountType.Current) {
            return account.getBalance();
        }

        changePlan(account);
        SavingAccountDetails savingAccountDetails = getSavingAccountDetails(account);
        double finalBalance = interestCalculator.calc(account.getBalance(), savingAccountDetails.getSavedFrom());

        return finalBalance;
    }

    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    public void createTransaction(Account account, String toAccountId, TransactionType type, double prev, double current) {
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), account.getId(), toAccountId, type, LocalDateTime.now(), prev, current);
        new TransactionDao().insert(transaction);
    }

    public List<Transaction> getTransactions(Account account) {
        List<Transaction> transactions = dataStorage.getTransactionRepository().get(transaction -> transaction.getAccountId().equals(account.getId()), Transaction.transactionByRecentnessComparator);
        return transactions;
    }

    public List<Transaction> getLatestTransactions(Account account, int n) {
        List<Transaction> transactions = getTransactions(account);
        transactions = transactions.subList(0, Math.min(n, transactions.size()));

        return transactions;
    }

    public boolean deposit(Account account, double amount) {
        double finalAmount = getBalance(account) + amount;

        createTransaction(account, null, TransactionType.Deposit, account.getBalance(), finalAmount);
        account.setBalance(finalAmount);
        updateAccount(account);

        if (account.getType() == AccountType.Saving) {
            SavingAccountDetails savingAccountDetails = dataStorage.getSavingAccountDetailsRepository().find(anySavingAccount -> anySavingAccount.getAccountId().equals(account.getId()));

            if (savingAccountDetails == null) {
                savingAccountDetails = new SavingAccountDetails(account.getId(), LocalDate.now(), null);
                new SavingAccountDao().insert(savingAccountDetails);
            } else {
                renewSavingDateWhenNecessary(account);
            }

        }

        return true;
    }

    public double imposeChargeWhenNecessary(Account account) {
        double charge = 0d;
        if (account.getType() == AccountType.Current) {
            if (account.getBalance() < MIN_BALANCE) {
               charge = CHARGE;
            }
        }

        return charge;
    }

    public void renewSavingDateWhenNecessary(Account account) {
        if (account.getType() == AccountType.Saving) {
            SavingAccountDetails savingAccountDetails = getSavingAccountDetails(account);
            savingAccountDetails.setSavedFrom(LocalDate.now());
            new SavingAccountDao().update(savingAccountDetails);
        }
    }

    public boolean withDraw(Account account, double amount) {
        double totalBalance = getBalance(account);

        amount += imposeChargeWhenNecessary(account);

        if (totalBalance < amount) {
            return false;
        }

        double finalBalance = totalBalance - amount;

        createTransaction(account, null, TransactionType.Withdraw, totalBalance, finalBalance);

        account.setBalance(finalBalance);
        renewSavingDateWhenNecessary(account);

        updateAccount(account);

        return true;
    }

    public boolean transfer(Account fromAccount, Account toAccount, double amount) {
        double totalBalance = getBalance(fromAccount);
        double totalAmount = amount;

        totalAmount += imposeChargeWhenNecessary(fromAccount);

        if (totalBalance < totalAmount) {
            return false;
        }

        createTransaction(fromAccount, toAccount.getId(), TransactionType.Transfer, totalBalance, totalBalance - totalAmount);
        fromAccount.setBalance(totalBalance - totalAmount);
        toAccount.updateBalance(amount);

        renewSavingDateWhenNecessary(fromAccount);
        updateAccount(fromAccount);
        updateAccount(toAccount);

        return true;
    }

}
