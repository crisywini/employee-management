package co.crisi.employee.adapter.decorator;

import co.crisi.employee.adapter.EmployeeDecoderAdapter;
import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.objectmother.EmployeeInfoMother;
import co.crisi.employee.port.api.EmployeeDecoderPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeNameDecoderDecoratorAdapterTest {

    private EmployeeDecoderPort decoder;

    @Test
    void decodeName(){
        var employee = EmployeeInfoMother.random();
        employee.setName("Bmcvt!Qfsdjwbm!Xvmgsjd!Csjbo");
        decoder = new EmployeeDecoderAdapter(employee);
        var nameDecoder = new EmployeeNameDecoderDecoratorAdapter(decoder);

        var employeeDecoded = nameDecoder.decode();

        assertThat(employeeDecoded.getName())
                .isNotNull()
                .isEqualTo("Albus Percival Wulfric Brian");


    }

}