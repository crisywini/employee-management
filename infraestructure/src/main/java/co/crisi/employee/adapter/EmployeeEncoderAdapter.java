package co.crisi.employee.adapter;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeEncoderPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeEncoderAdapter implements EmployeeEncoderPort {

    private EmployeeInfo employee;

    @Override
    public EmployeeInfo encode() {
        return employee;
    }

}
