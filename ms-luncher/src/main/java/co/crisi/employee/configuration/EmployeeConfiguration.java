package co.crisi.employee.configuration;

import co.crisi.employee.adapter.EmployeeJpaAdapter;
import co.crisi.employee.port.api.EmployeeServicePort;
import co.crisi.employee.port.spi.EmployeePersistencePort;
import co.crisi.employee.service.DateServicePortImpl;
import co.crisi.employee.service.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {

    @Bean
    public EmployeePersistencePort employeePersistence() {
        return new EmployeeJpaAdapter();
    }

    @Bean
    public EmployeeServicePort employeeService() {
        return new EmployeeServiceImpl(employeePersistence(), new DateServicePortImpl());
    }


}
