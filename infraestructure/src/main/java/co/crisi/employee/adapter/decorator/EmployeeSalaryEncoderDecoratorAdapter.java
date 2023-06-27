package co.crisi.employee.adapter.decorator;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeEncoderPort;

public class EmployeeSalaryEncoderDecoratorAdapter extends EmployeeEncoderDecoratorAdapter {

    public EmployeeSalaryEncoderDecoratorAdapter(EmployeeEncoderPort encoder) {
        super(encoder);
    }

    @Override
    public EmployeeInfo encode() {
        var employee = super.encode();
        employee.setBasicSalary(encodeSalary(employee.getBasicSalary()));
        return employee;
    }

    public Double encodeSalary(Double salary) {
        return salary / 2.0;
    }

}