package models;

public class SavingPlan {
    private static SavingPlan defaultSavingPlan;
    private String id;
    private String accountId;
    private int monthsInterval;
    private double rate;

    private SavingPlan() {
        this.monthsInterval = 1;
        this.rate = .1;
    }

    public static SavingPlan getDefaultSavingPlan() {
        if (defaultSavingPlan == null) {
            defaultSavingPlan = new SavingPlan();
        }
        return defaultSavingPlan;
    }

    public SavingPlan(String id, String accountId, int monthsInterval, double rate) {
        this.id = id;
        this.accountId = accountId;
        this.monthsInterval = monthsInterval;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getMonthsInterval() {
        return monthsInterval;
    }

    public void setMonthsInterval(int monthsInterval) {
        this.monthsInterval = monthsInterval;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
