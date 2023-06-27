package co.crisi.employee.adapter.decorator;

import co.crisi.employee.adapter.EmployeeEncoderAdapter;
import co.crisi.employee.objectmother.EmployeeInfoMother;
import co.crisi.employee.port.api.EmployeeEncoderPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeSalaryEncoderDecoratorAdapterTest {

    private EmployeeEncoderPort encoder;


    @Test
    void encodeSalary() {
        var employee = EmployeeInfoMother.random();
        encoder = new EmployeeEncoderAdapter(employee);
        var salaryEncoder = new EmployeeSalaryEncoderDecoratorAdapter(encoder);

        var employeeEncoded = salaryEncoder.encode();

        assertThat(employeeEncoded.getBasicSalary())
                .isEqualTo(1000000000.0 / 2.0);

    }

}