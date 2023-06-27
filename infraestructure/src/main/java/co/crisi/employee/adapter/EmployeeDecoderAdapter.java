package co.crisi.employee.adapter;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeDecoderPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeDecoderAdapter implements EmployeeDecoderPort {

    private EmployeeInfo employee;

    @Override
    public EmployeeInfo decode() {
        return employee;
    }

}
