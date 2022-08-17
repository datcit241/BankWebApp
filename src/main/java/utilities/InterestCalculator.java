package utilities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface InterestCalculator {
    double calc(double balance, LocalDate fromDate);
    default long monthBetween(LocalDate fromDate, LocalDate toDate) {
        long monthBetween = ChronoUnit.MONTHS.between(fromDate, toDate);
        return monthBetween;
    }
}
