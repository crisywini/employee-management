package co.crisi.employee.mapper;

import co.crisi.employee.data.Date;
import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.model.Employee;
import java.time.LocalDate;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "dateOfAdmission", source = "admissionDate")
    @Mapping(target = "id", source = "personalId")
    EmployeeInfo mapToInfo(Employee employee);


    @Mapping(target = "admissionDate", source = "dateOfAdmission")
    @Mapping(target = "personalId", source = "id")
    @Mapping(target = "id", ignore = true)
    Employee mapToEntity(EmployeeInfo employeeInfo);

    List<Employee> mapToEntity(List<EmployeeInfo> employeesInfo);

    List<EmployeeInfo> mapToInfo(List<Employee> employees);

    default Date mapToDate(LocalDate localDate) {
        return Date.builder()
                .day(localDate.getDayOfMonth())
                .month(localDate.getMonthValue())
                .year(localDate.getYear())
                .build();
    }

    default LocalDate mapToLocalDate(Date date) {
        return LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
    }

}
