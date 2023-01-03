package co.crisi.employee.service;

import co.crisi.employee.data.Date;
import co.crisi.employee.port.api.DateServicePort;
import java.time.LocalDate;
import java.util.Optional;

public class DateServicePortImpl implements DateServicePort {

    private static final String DATE_NULL_MESSAGE = "Some dates are null";

    @Override
    public int getDifferenceBetweenDates(Date dateOne, Date dateTwo) {

        validateDates(dateOne, dateTwo);

        int differenceInMonths = Math.abs(dateOne.getMonth() - dateTwo.getMonth());
        int differenceInYears = Math.abs(dateOne.getYear() - dateTwo.getYear());
        int result = differenceInYears * 12 + differenceInMonths;
        return (dateTwo.getDay() < dateOne.getDay()) ? result - 1 : result;
    }

    @Override
    public Date getCurrentDate() {
        LocalDate date = LocalDate.now();
        return Date.builder()
                .day(date.getDayOfMonth())
                .month(date.getMonthValue())
                .year(date.getYear())
                .build();
    }

    private void validateDates(Date dateOne, Date dateTwo) {
        Optional.ofNullable(dateOne)
                .orElseThrow(() -> new NullPointerException(DATE_NULL_MESSAGE));
        Optional.ofNullable(dateTwo)
                .orElseThrow(() -> new NullPointerException(DATE_NULL_MESSAGE));
    }

}
