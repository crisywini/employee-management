package co.crisi.employee.port.api;

import co.crisi.employee.data.EmployeeInfo;
import java.util.List;
import org.springframework.stereotype.Service;

public interface EmployeeServicePort {

    EmployeeInfo getById(Long id);

    EmployeeInfo add(EmployeeInfo employeeInfo);

    void deleteById(Long id);

    int getAgeByDate(Long employeeId);

    int getSeniority(Long employeeId);

    EmployeeInfo update(EmployeeInfo newEmployeeInfo);

    Double getBenefits(Long employeeId);

    List<EmployeeInfo> findAll();

}
