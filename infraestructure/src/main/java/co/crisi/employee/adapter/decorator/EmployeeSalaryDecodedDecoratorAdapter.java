package co.crisi.employee.adapter.decorator;


import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeDecoderPort;

public class EmployeeSalaryDecodedDecoratorAdapter extends EmployeeDecoderDecoratorAdapter {


    public EmployeeSalaryDecodedDecoratorAdapter(EmployeeDecoderPort decoder) {
        super(decoder);
    }

    @Override
    public EmployeeInfo decode() {
        var decoded = super.decoder.decode();
        decoded.setBasicSalary(decodeSalary(decoded.getBasicSalary()));
        return decoded;
    }

    private Double decodeSalary(Double salary) {
        return salary * 2.0;
    }

}
