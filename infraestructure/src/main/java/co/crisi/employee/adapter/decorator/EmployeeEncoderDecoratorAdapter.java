package co.crisi.employee.adapter.decorator;


import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeEncoderPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class EmployeeEncoderDecoratorAdapter implements EmployeeEncoderPort {

    protected EmployeeEncoderPort encoder;

    @Override
    public EmployeeInfo encode() {
        return this.encoder.encode();
    }

}
