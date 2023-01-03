package co.crisi.employee.mapper;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.model.Employee;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    EmployeeInfo mapToInfo(Employee employee);

    Employee mapToEntity(EmployeeInfo employeeInfo);

    List<Employee> mapToEntity(List<EmployeeInfo> employeesInfo);

    List<EmployeeInfo> mapToInfo(List<Employee> employees);

}
