package co.crisi.employee.objectmother;

import co.crisi.employee.model.Employee;
import java.time.LocalDate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeMother {

    public Employee random() {
        return Employee.builder()
                .id(1L)
                .name("Albus Percival Wulfric Brian")
                .lastName("Dumbledore")
                .basicSalary(1000000000.0)
                .birthDate(LocalDate.of(1881, 8, 30))
                .admissionDate(LocalDate.of(1910, 1, 1))
                .build();
    }

}
