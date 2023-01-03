package co.crisi.employee.port.spi;

import co.crisi.employee.data.EmployeeInfo;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

public interface EmployeePersistencePort {

    EmployeeInfo save(EmployeeInfo employee);

    void deleteById(Long id);

    EmployeeInfo update(EmployeeInfo newEmployee);

    List<EmployeeInfo> findAll();

    Optional<EmployeeInfo> findById(Long id);

}
