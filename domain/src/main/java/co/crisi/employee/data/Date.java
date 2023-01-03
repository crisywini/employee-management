package co.crisi.employee.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Date {

    private int day;

    private int month;

    private int year;

}
