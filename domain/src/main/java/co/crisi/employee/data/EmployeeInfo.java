package co.crisi.employee.data;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class EmployeeInfo {

    private Long id;

    private String name;

    private String lastName;

    private Double basicSalary;

    private Date dateOfAdmission;

    private Date birthDate;

}
