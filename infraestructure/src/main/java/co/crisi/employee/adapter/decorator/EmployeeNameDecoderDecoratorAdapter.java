package co.crisi.employee.adapter.decorator;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeDecoderPort;

public class EmployeeNameDecoderDecoratorAdapter extends EmployeeDecoderDecoratorAdapter {


    public EmployeeNameDecoderDecoratorAdapter(EmployeeDecoderPort decoder) {
        super(decoder);
    }

    @Override
    public EmployeeInfo decode() {
        var decoded = this.decoder.decode();
        decoded.setName(decodeNameUsingCaesarOne(decoded.getName()));
        return decoded;
    }

    private String decodeNameUsingCaesarOne(String name) {
        var decoded = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            decoded.append(name.charAt(i) - 1);
        }
        return decoded.toString();
    }

}
