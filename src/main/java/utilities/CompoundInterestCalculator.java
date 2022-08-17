package utilities;

import models.SavingPlan;

import java.time.LocalDate;

public class CompoundInterestCalculator implements InterestCalculator {
    private SavingPlan savingPlan;

    public CompoundInterestCalculator(SavingPlan savingPlan) {
        this.savingPlan = savingPlan;
    }

    @Override
    public double calc(double balance, LocalDate fromDate) {
        LocalDate now = LocalDate.now();
        long months = monthBetween(fromDate, now);

        double finalAmount = balance * Math.pow(1 + savingPlan.getRate() / savingPlan.getMonthsInterval(), savingPlan.getMonthsInterval() * months);
        return finalAmount;
    }

    public SavingPlan getSavingPlan() {
        return savingPlan;
    }

    public void setSavingPlan(SavingPlan savingPlan) {
        this.savingPlan = savingPlan;
    }
}
