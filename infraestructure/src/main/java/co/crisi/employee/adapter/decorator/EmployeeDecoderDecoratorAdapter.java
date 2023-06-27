package co.crisi.employee.adapter.decorator;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeDecoderPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class EmployeeDecoderDecoratorAdapter implements EmployeeDecoderPort {

    protected EmployeeDecoderPort decoder;

    @Override
    public EmployeeInfo decode() {
        return decoder.decode();
    }

}
