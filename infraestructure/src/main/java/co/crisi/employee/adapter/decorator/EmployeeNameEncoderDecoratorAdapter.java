package co.crisi.employee.adapter.decorator;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeEncoderPort;

public class EmployeeNameEncoderDecoratorAdapter extends EmployeeEncoderDecoratorAdapter {

    public EmployeeNameEncoderDecoratorAdapter(EmployeeEncoderPort encoder) {
        super(encoder);
    }

    @Override
    public EmployeeInfo encode() {
        var employee = this.encoder.encode();
        employee.setName(encodeName(employee.getName()));
        return employee;
    }

    private String encodeName(String name) {
        StringBuilder encodedName = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            encodedName.append((char) (name.charAt(i) + 1));
        }
        return encodedName.toString();
    }

}
