package co.crisi.employee.service;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.DateServicePort;
import co.crisi.employee.port.api.EmployeeServicePort;
import co.crisi.employee.port.spi.EmployeePersistencePort;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeServicePort {

    private EmployeePersistencePort employeePersistencePort;

    private DateServicePort dateServicePort;

    @Override
    public EmployeeInfo getById(Long id) {
        return employeePersistencePort.findByPersonalId(id)
                .orElseThrow(() -> new NullPointerException("Employee not found!"));
    }

    @Override
    public EmployeeInfo add(EmployeeInfo employeeInfo) {
        return employeePersistencePort.save(employeeInfo);
    }

    @Override
    public void deleteById(Long id) {
        employeePersistencePort.deleteById(id);
    }

    @Override
    public int getAgeByDate(Long employeeId) {

        EmployeeInfo employeeInfo = getById(employeeId);
        return dateServicePort.getDifferenceBetweenDates(employeeInfo.getBirthDate(), dateServicePort.getCurrentDate())
                / 12;
    }

    @Override
    public int getSeniority(Long employeeId) {
        EmployeeInfo employeeInfo = getById(employeeId);
        return dateServicePort.getDifferenceBetweenDates(employeeInfo.getDateOfAdmission(),
                dateServicePort.getCurrentDate())
                / 12;
    }

    @Override
    public EmployeeInfo update(Long employeeId, EmployeeInfo newEmployeeInfo) {
        return employeePersistencePort.update(employeeId, newEmployeeInfo);
    }

    @Override
    public Double getBenefits(Long employeeId) {
        EmployeeInfo employeeInfo = getById(employeeId);
        return (getSeniority(employeeId) * employeeInfo.getBasicSalary()) / 12;
    }

    @Override
    public List<EmployeeInfo> findAll() {
        return employeePersistencePort.findAll();
    }

}
