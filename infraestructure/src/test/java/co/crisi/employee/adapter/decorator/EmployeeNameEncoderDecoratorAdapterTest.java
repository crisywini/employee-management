package co.crisi.employee.adapter.decorator;

import co.crisi.employee.adapter.EmployeeEncoderAdapter;
import co.crisi.employee.objectmother.EmployeeInfoMother;
import co.crisi.employee.port.api.EmployeeEncoderPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeNameEncoderDecoratorAdapterTest {

    private EmployeeEncoderPort encoder;


    @Test
    void encodeNameTest(){
        var employee = EmployeeInfoMother.random();

        encoder = new EmployeeEncoderAdapter(employee);
        var nameEncoder = new EmployeeNameEncoderDecoratorAdapter(encoder);

        var employeeEncoded = nameEncoder.encode();
        assertThat(employeeEncoded.getName())
                .isNotNull()
                .isEqualTo("Bmcvt!Qfsdjwbm!Xvmgsjd!Csjbo");

    }


}