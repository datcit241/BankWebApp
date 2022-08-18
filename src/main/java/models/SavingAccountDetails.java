package models;

import java.time.LocalDate;

public class SavingAccountDetails {
    private String accountId;
    private LocalDate savedFrom;
    private String savingPlanId;

    public SavingAccountDetails(String accountId, LocalDate savedFrom, String savingPlanId) {
        this.accountId = accountId;
        this.savedFrom = savedFrom;
        this.savingPlanId = savingPlanId;
    }

    public String getAccountId() { return accountId; }

    public LocalDate getSavedFrom() { return savedFrom; }
    public void setSavedFrom(LocalDate savedFrom) { this.savedFrom = savedFrom; }

    public String getSavingPlanId() { return savingPlanId; }
    public void setSavingPlanId(String savingPlanId) { this.savingPlanId = savingPlanId; }

    @Override
    public String toString() {
        return "'" + accountId + "'," +
                "'" + savedFrom + "'," +
                "'" + savingPlanId + "'";
    }
}
