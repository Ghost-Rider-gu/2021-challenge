package siendev.corp.apps.dates;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {

    public Period compareDates(LocalDate firstDate, LocalDate secondDate) {
        return Period.between(firstDate, secondDate);
    }

    public Period compareDates(LocalDate date) {
        LocalDate today = LocalDate.now();
        return Period.between(date, today);
    }

    public Period compareDates(String firstDate, String secondDate) {
        LocalDate parseFirstDate = LocalDate.parse(firstDate);
        LocalDate parseSecondDate= LocalDate.parse(secondDate);
        return Period.between(parseFirstDate, parseSecondDate);
    }
}
