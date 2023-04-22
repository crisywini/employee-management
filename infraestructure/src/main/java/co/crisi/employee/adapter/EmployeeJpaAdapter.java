package co.crisi.employee.adapter;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.mapper.EmployeeMapper;
import co.crisi.employee.port.spi.EmployeePersistencePort;
import co.crisi.employee.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeJpaAdapter implements EmployeePersistencePort {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @Override
    public EmployeeInfo save(EmployeeInfo employee) {
        return EMPLOYEE_MAPPER.mapToInfo(employeeRepository.save(EMPLOYEE_MAPPER.mapToEntity(employee)));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED, isolation = Isolation.REPEATABLE_READ)
    public EmployeeInfo update(Long employeeId, EmployeeInfo newEmployee) {
        return employeeRepository.findByPersonalId(employeeId)
                .map(employee -> {

                    var employeeUpdated = EMPLOYEE_MAPPER.mapToEntity(newEmployee);
                    employeeUpdated.setId(employee.getId());
                    employeeUpdated.setPersonalId(employeeId);

                    return EMPLOYEE_MAPPER.mapToInfo(employeeRepository.save(employeeUpdated));
                })
                .orElseThrow(() -> new NullPointerException("Employee not found"));
    }

    @Override
    public List<EmployeeInfo> findAll() {
        return EMPLOYEE_MAPPER.mapToInfo(employeeRepository.findAll());
    }

    @Override
    public Optional<EmployeeInfo> findByPersonalId(Long id) {
        return Optional.ofNullable(EMPLOYEE_MAPPER.mapToInfo(employeeRepository.findByPersonalId(id)
                .orElseThrow(() -> new NullPointerException("Employee not found"))));
    }

}
