package co.crisi.employee.port.api;

import co.crisi.employee.data.Date;

public interface DateServicePort {

    int getDifferenceBetweenDates(Date dateOne, Date dateTwo);

    Date getCurrentDate();
}
