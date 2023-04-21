package co.crisi.employee.mapper;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.model.Employee;
import co.crisi.employee.objectmother.EmployeeInfoMother;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeMapperTest {


    private final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);


    @Test
    void infoToEntityTest(){
        val employeeInfo = EmployeeInfoMother.random();
        val birthDateLD = employeeMapper.mapToLocalDate(employeeInfo.getBirthDate());
        val admissionDateLD = employeeMapper.mapToLocalDate(employeeInfo.getDateOfAdmission());

        val employeeEntity = employeeMapper.mapToEntity(employeeInfo);

        assertThat(employeeEntity)
                .extracting(Employee::getId,
                        Employee::getName,
                        Employee::getLastName,
                        Employee::getBasicSalary,
                        Employee::getBirthDate,
                        Employee::getAdmissionDate)
                .contains(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getLastName(),
                        employeeInfo.getBasicSalary(),
                        birthDateLD,
                        admissionDateLD);
    }

}