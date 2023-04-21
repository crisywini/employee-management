package co.crisi.employee.objectmother;

import co.crisi.employee.data.Date;
import co.crisi.employee.data.EmployeeInfo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeInfoMother {

    public EmployeeInfo random() {
        return EmployeeInfo.builder()
                .id(1L)
                .name("Albus Percival Wulfric Brian")
                .lastName("Dumbledore")
                .basicSalary(1000000000.0)
                .birthDate(Date.builder()
                        .year(1881)
                        .day(30)
                        .month(8)
                        .build())
                .dateOfAdmission(Date.builder()
                        .year(1910)
                        .day(1)
                        .month(1)
                        .build())
                .build();
    }

}
