package co.crisi.employee.adapter.decorator;

import co.crisi.employee.adapter.EmployeeDecoderAdapter;
import co.crisi.employee.objectmother.EmployeeInfoMother;
import co.crisi.employee.port.api.EmployeeDecoderPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeSalaryDecodedDecoratorAdapterTest {

    private EmployeeDecoderPort decoder;

    @Test
    void decodeSalary() {
        var employee = EmployeeInfoMother.random();
        employee.setBasicSalary(1000000000.0 / 2.0);
        decoder = new EmployeeDecoderAdapter(employee);
        var decoderSalary = new EmployeeSalaryDecodedDecoratorAdapter(decoder);

        var decodedEmployee = decoderSalary.decode();

        assertThat(decodedEmployee.getBasicSalary())
                .isEqualTo(1000000000.0);
    }

}